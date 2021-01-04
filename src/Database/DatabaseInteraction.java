package Database;

import com.jfoenix.controls.JFXBadge;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseInteraction {
    private Connection cn=null;
    private Statement st = null;
    String databaseName = "projettutorat";
    String databaseUser = "root";
    String databasePassword = "";
    String url = "jdbc:mysql://localhost/"+databaseName;
    private  static  ArrayList<String> user = new ArrayList<String>();;

    public DatabaseInteraction() throws SQLException, ClassNotFoundException {
        cn = DatabaseConection.getInstance(url, databaseUser,databasePassword);
    }

    public void validationLogin(String identifiant, String password) {
        //Connection a la Base de donnée
        //Preparation de la requête
        String verifyLogin = "SELECT count(1) FROM user WHERE  ( userNumEtu = '"+identifiant+
                "' OR userMail = '"+identifiant+"' ) AND password = '"+password+"'";
        try{
            //execution de la reqête
            st = cn.createStatement();
            lastUser(identifiant);
            ResultSet resultSet = st.executeQuery(verifyLogin);
            //verification des informatiions dans la Base
            while (resultSet.next()){
                if (resultSet.getInt(1)==1) {
                    System.out.println("Connection impossible, veillez à ressayer prochainement." + user.get(0));
                }
            }
        } catch (Exception e){ e.printStackTrace(); e.getCause(); }
    }

    //Statue de l'utilisateur pour rediriger vers le bon interface
    public String getStatutConnection(String identifiant, String password) throws SQLException, IOException {
        String statut = null;
        String req = "SELECT statut FROM user WHERE ( userNumEtu = '"+identifiant+
                "' OR userMail = '"+identifiant+"' ) AND password = '"+password+"'";
        st = cn.createStatement();
        ResultSet resultSetStatut = st.executeQuery(req);
        while (resultSetStatut.next()) {
            statut = resultSetStatut.getString("statut");
        }
        return statut;
    }

    public String DatabaseRequest(String req) throws SQLException {
        st = cn.createStatement();
        ResultSet resultSet = st.executeQuery(req);
        String result = null;
        while (resultSet.next()) {
            result = resultSet.toString();
        }
        return result;
    }

    public void lastUser(String u){
        user.add(u);
    }

    public  String lastUserConnected(){
        return user.get(0);
    }



}
