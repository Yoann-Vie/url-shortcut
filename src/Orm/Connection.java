package Orm;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    public static java.sql.Connection get()
        throws SQLException, ClassNotFoundException, NamingException
    {
        String driverName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverName);
            InitialContext ic = new InitialContext();

            String serverName = (String) ic.lookup("java:comp/env/db/serverName");
            String database = (String) ic.lookup("java:comp/env/db/database");
            String url = "jdbc:mysql://" + serverName + "/" + database;
            String username = (String) ic.lookup("java:comp/env/db/username");
            String password = "";

            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
