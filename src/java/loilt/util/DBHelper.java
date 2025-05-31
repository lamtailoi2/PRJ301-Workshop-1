package loilt.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper implements Serializable {

    private final static String DB_NAME = "LOILT_SU25";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "Admin123!";

    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName= " + DB_NAME;
        Connection con = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
        return con;
    }
}
