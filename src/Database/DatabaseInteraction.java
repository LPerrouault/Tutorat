package Database;

import com.jfoenix.controls.JFXBadge;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import javafx.fxml.FXMLLoader;


import javax.activation.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseInteraction  {
    private Connection cn=null;
     Statement st = null;
     ResultSet rs = null;
     //detaille Connection Database sur Gooogle Cloud
    String databaseName = "tutorat";
    String databaseUser = "root";
    String databasePassword = "";
    String localConnection = "jdbc:mysql://localhost/"+databaseName;

/*    String CloudDatabasePassword = "B0wNnxtzA0DiyEbo";
    String CloudSQLConnection = "progibdgl-tutorat:europe-west1:progtutorat";

    private DataSource createConnection(){
        // The configuration object specifies behaviors for the connection pool.
        final HikariDataSource config = new HikariDataSource();
        // Configure which instance and what database user to connect with.
        config.setJdbcUrl(String.format("jdbc:mysql:///%s", databaseName));
        config.setUsername(databaseUser); // e.g. "root", "postgres"
        config.setPassword(CloudDatabasePassword); // e.g. "my-password"

        // For Java users, the Cloud SQL JDBC Socket Factory can provide authenticated connections.
        config.addDataSourceProperty("socketFactory", "com.google.cloud.sql.mysql.SocketFactory");
        config.addDataSourceProperty("cloudSqlInstance", CloudSQLConnection);
        config.addDataSourceProperty("useSSL", "false");

        // Initialize the connection pool using the configuration object.
        DataSource pool = (DataSource) new HikariDataSource(config);
        return pool;
    }*/

    private  static  ArrayList<String> user = new ArrayList<String>();
    private ArrayList<String> userStatut = new ArrayList<>();

    public DatabaseInteraction() throws SQLException, ClassNotFoundException {
        cn = DatabaseConection.getInstance(localConnection, databaseUser,databasePassword);
    }

    public void validationLogin(String identifiant, String password) {
        //Connection a la Base de donnée
        //Preparation de la requête
        lastUser(identifiant);
        String verifyLogin = "SELECT count(1) FROM user WHERE  ( userNumEtu = '"+identifiant+
                "' OR userMail = '"+identifiant+"' ) AND password = '"+password+"'";
        try{
            //execution de la reqête
            st = cn.createStatement();
            rs = st.executeQuery(verifyLogin);
            //verification des informatiions dans la Base
            while (rs.next()){
                if (rs.getInt(1)==1) {
                }
            }
        } catch (Exception e){ e.printStackTrace(); e.getCause(); }
    }

    //Statue de l'utilisateur pour rediriger vers le bon espace d'affichage
    public String getStatutConnection(String identifiant, String password) throws SQLException, IOException {
        String statut = null;
        String req = "SELECT statut FROM user WHERE ( userNumEtu = '"+identifiant+
                "' OR userMail = '"+identifiant+"' ) AND password = '"+password+"'";
        st = cn.createStatement();
        rs = st.executeQuery(req);
        while (rs.next()) {
            statut = rs.getString("statut");
            lastUserStatut(statut);
        }
        return statut;
    }

    public String DatabaseRequest(String req, String col) throws SQLException {
        String result = "";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(req);
            while (rs.next())
                 result = rs.getString(col);
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }


    public void DatabaseUpdate(String req) throws SQLException {
        try {
            st = cn.createStatement();
            st.execute(req);
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void lastUser(String u){
        user.add(u);
    }

    public void  lastUserStatut(String u){ userStatut.add(u);}

    public  String lastUserConnected(){
        return user.get(user.size()-1);
    }



}
