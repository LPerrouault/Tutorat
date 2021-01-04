package Category;

import Database.DatabaseInteraction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class profile implements Initializable {

    @FXML
    javafx.scene.control.Label  labelNumEtu;
    @FXML
    javafx.scene.control.Label labelNom;
    @FXML
    javafx.scene.control.Label  labelPrenom;
    @FXML
    javafx.scene.control.Label  labelMail;
    @FXML
    javafx.scene.control.Label  labelStatut;

    String user,reqNumEtu,reqNom,reqPrenom,reqMail,reqStatut;
    String resultNumEtu,resultNom,resultPrenom,resultMail,resultStatut;
    DatabaseInteraction databaseInteraction = new DatabaseInteraction();

    public profile() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelNumEtu.setText("resultNumEtu");
        labelNom.setText("resultNom");
        labelPrenom.setText("resultPrenom");
        labelMail.setText("resultMail");
        labelStatut.setText("resultStatut");
    }

    public void DataBaseReq() throws SQLException {
        user = databaseInteraction.lastUserConnected();
        reqNumEtu = "SELECT userNumetu FROM user where userNumetu="+user+" or userMail ="+user;
        resultNumEtu = databaseInteraction.DatabaseRequest(reqNumEtu);

        reqNom = "SELECT userNom FROM user where userNumetu="+user+" or userMail ="+user;
        resultNom = databaseInteraction.DatabaseRequest(reqNom);

        reqPrenom = "SELECT userPrenom FROM user where userNumetu="+user+" or userMail ="+user;
        resultPrenom = databaseInteraction.DatabaseRequest(reqPrenom);

        reqMail = "SELECT usermail FROM user where userNumetu="+user+" or userMail ="+user;
        resultMail = databaseInteraction.DatabaseRequest(reqMail);

        reqStatut = "SELECT statut FROM user where userNumetu="+user+" or userMail ="+user;
        reqStatut = databaseInteraction.DatabaseRequest(reqStatut);
    }

    public void initialisationLabel(){
        System.out.printf(resultNumEtu);
        System.out.printf(resultNom);
        System.out.printf(resultPrenom);
        System.out.printf(resultMail);
        System.out.printf(resultStatut);

        labelNumEtu.setText(resultNumEtu);
        labelNom.setText(resultNom);
        labelPrenom.setText(resultPrenom);
        labelMail.setText(resultMail);
        labelStatut.setText(resultStatut);
    }


}
