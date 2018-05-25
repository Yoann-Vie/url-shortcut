package Orm;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Query {

    private java.sql.Connection connection;
    private java.sql.PreparedStatement statement;

    /**
     * Query constructor
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public Query()
        throws SQLException, ClassNotFoundException, NamingException
    {
        this.connection = Connection.get();
    }

    /**
     * Insert query method
     * @param tableName String
     * @param fields ArrayList<String>
     * @param values ArrayList<String>
     * @throws SQLException
     */
    public void insert(String tableName, ArrayList<String> fields, ArrayList<String> values)
        throws SQLException
    {
        fields.remove(0);
        String queryFields = String.join(", ", fields);
        String queryValues = String.join(", ", values);
        String query = "INSERT INTO " + tableName + "(" + queryFields + ")" + " VALUES (" + queryValues + ")";

        this.statement = this.connection.prepareStatement(query);
        this.statement.executeUpdate();
        this.statement.close();
    }

    /**
     * Delete query method
     * @param tableName String
     * @param id Integer
     * @throws SQLException
     */
    public void delete(String tableName, Integer id)
        throws SQLException
    {
        String query = "DELETE FROM " + tableName + " WHERE id=?";

        this.statement = this.connection.prepareStatement(query);
        this.statement.setInt(1, id);
        this.statement.executeUpdate();
        this.statement.close();
    }

    /**
     * Select query method
     * @param tableName String
     * @param fields ArrayList<String>
     * @return ArrayList
     * @throws SQLException
     */
    public ArrayList select(String tableName, ArrayList<String> fields)
       throws SQLException
    {
        String queryFields = String.join(", ", fields);
        String query = "SELECT " + queryFields + " FROM " + tableName;

        this.statement = this.connection.prepareStatement(query);
        ResultSet results = this.statement.executeQuery();
        ArrayList formattedResults = this.getResult(results);
        this.statement.close();

        return formattedResults;
    }

    /**
     * Select query method with where statement
     * @param tableName String
     * @param fields ArrayList<String>
     * @param condition HashMap<String,String>
     * @return ArrayList
     * @throws SQLException
     */
    public ArrayList selectWhere(String tableName, ArrayList<String> fields, HashMap<String,String> condition)
       throws SQLException
    {
        String queryFields = String.join(", ", fields);
        String query = "SELECT " + queryFields + " FROM " + tableName + " WHERE ";
        Integer count = 0;
        for (Map.Entry<String,String> entry : condition.entrySet()) {
            if (count > 0) {
                query = query + "AND ";
            }
            query = query + entry.getKey() + "=?";
            count++;
        }

        this.statement = this.connection.prepareStatement(query);
        count = 0;
        for (Map.Entry<String,String> entry : condition.entrySet()) {
            this.statement.setString(count + 1, entry.getValue());
            count++;
        }
        ResultSet results = this.statement.executeQuery();
        ArrayList formattedResults = this.getResult(results);
        this.statement.close();

        return formattedResults;
    }

    /**
     * Get request results as ArrayList Object
     * @param results ResultSet
     * @return ArrayList
     * @throws SQLException
     */
    private ArrayList getResult(ResultSet results)
        throws SQLException
    {
        ArrayList formattedResults = new ArrayList();
        while(results.next()) {
            Map resultRow = new HashMap<>();
            resultRow.put("id", results.getInt("id"));
            resultRow.put("username", results.getString("username"));
            resultRow.put("email", results.getString("email"));

            formattedResults.add(resultRow);
        }

        return formattedResults;
    }

    /**
     * Close statement
     * @throws SQLException
     */
    public void close()
        throws SQLException
    {
        this.statement.close();
    }
}
