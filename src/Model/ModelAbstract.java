package Model;

import Helper.Tools;
import Orm.Query;

import javax.naming.NamingException;
import java.beans.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ModelAbstract
{
    protected Integer id;
    public ArrayList<String> fields;
    public String tableName;

    abstract public ArrayList getValues();

    public Integer getId() { return this.id; }

    /**
     * Find model instance by Id
     * @param id Integer
     * @return ModelAbstract
     */
    public ModelAbstract find(Integer id)
    {
        return this.find("id", id.toString());
    }

    /**
     * Find model instance using attribute condition
     * @param fieldName String
     * @param fieldValue String
     * @return ModelAbstract
     */
    public ModelAbstract find(String fieldName, String fieldValue)
    {
        HashMap condition = new HashMap();
        condition.put(fieldName, fieldValue);
        try {
            ArrayList<HashMap> response = new Query().selectWhere(this.tableName, this.fields, condition);
            HashMap modelData = response.get(0);

            for (String field : this.fields) {
                new Statement(this, "set" + Tools.ucfirst(field), new Object[]{modelData.get(field)}).execute();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return this;
    }

    /**
     * Find all instance of current model
     * @return ArrayList
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public ArrayList findAll()
        throws SQLException, ClassNotFoundException, NamingException
    {
        return new Query().select(this.tableName, this.fields);
    }

    /**
     * Persist current instance
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public void persist()
        throws SQLException, ClassNotFoundException, NamingException
    {
        new Query().insert(this.tableName, this.fields, this.getValues());
        // TODO : manage update
    }

    /**
     * Delete current instance
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public void delete()
        throws SQLException, ClassNotFoundException, NamingException
    {
        new Query().delete(this.tableName, this.getId());
    }

    /**
     * Set id from Integer
     * @param id Integer
     * @return
     */
    public ModelAbstract setId(Integer id) {
        this.id = id;

        return this;
    }

    /**
     * Set id from String
     * @param id
     * @return
     */
    public ModelAbstract setId(String id) {
        this.id = new Integer(id);

        return this;
    }
}
