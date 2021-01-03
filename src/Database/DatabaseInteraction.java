package Database;

import com.jfoenix.controls.JFXBadge;

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
    ArrayList<String> userStatut;

    public DatabaseInteraction() throws SQLException, ClassNotFoundException {
        cn = DatabaseConection.getInstance(url, databaseUser,databasePassword);
        userStatut= new ArrayList<String>();
    }

    public void validationLogin(String identifiant, String password) {
        //Connection a la Base de donnée
        //Preparation de la requête
        String verifyLogin = "Select count(1) from user where ( userNumEtu = '"+identifiant+
                "' OR userMail = '"+identifiant+"' ) AND password = '"+password+"'";
        try{
            //execution de la reqête
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(verifyLogin);
            //verification des informatiions dans la Base
            while (resultSet.next()){
                JFXBadge messageConnection = new JFXBadge();
                if (resultSet.getInt(1)==1)
                    messageConnection.setText("Connection impossible, veillez à ressayer prochainement.");
            }
        } catch (Exception e){ e.printStackTrace(); e.getCause(); }
    }

    //Statue de l'utilisateur pour rediriger vers le bon interface
    public String getStatutConnection(String identifiant, String password) throws SQLException {
        String statut = null;
        String req = "Select statut from user where ( userNumEtu = '"+identifiant+
                "' OR userMail = '"+identifiant+"' ) AND password = '"+password+"'";
        st = cn.createStatement();
        ResultSet resultSetStatut = st.executeQuery(req);
        while (resultSetStatut.next()) {
            statut = resultSetStatut.getString("statut");
        }
        userStatut.add(statut);
        return statut;
    }
}
