package Database;

import com.jfoenix.controls.JFXBadge;
import javafx.fxml.FXMLLoader;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseInteraction {
    private Connection cn=null;
     Statement st = null;
     ResultSet rs = null;
     //detaille Connection Database sur Gooogle Cloud
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
        rs = st.executeQuery(req);
        while (rs.next()) {
            statut = rs.getString("statut");
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

    public  String lastUserConnected(){
        return user.get(user.size()-1);
    }



}
