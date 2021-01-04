package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConection {

    private static Connection connect;

    private  DatabaseConection(String url, String login, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection(url, login, password);
    }

    public static Connection getInstance(String url, String login, String password) throws ClassNotFoundException, SQLException{
            if(connect == null){
                new DatabaseConection(url, login, password);
            }
            return connect;
    }

}
