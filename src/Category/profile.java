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
    javafx.scene.control.Label  labelFiliere;
    @FXML
    javafx.scene.control.Label  labelStatut;


    //requete SQL permetant l'affichage des information
    DatabaseInteraction databaseInteraction = new DatabaseInteraction();
    String user =  databaseInteraction.lastUserConnected();
    String reqNumEtu = "SELECT userNumetu FROM user where userNumetu="+user+" or userMail ="+user;
    String resultNumEtu = databaseInteraction.DatabaseRequest(reqNumEtu, "userNumEtu");
    String reqNom = "SELECT userNom FROM user where userNumetu="+user+" or userMail ="+user;
    String resultNom = databaseInteraction.DatabaseRequest(reqNom, "userNom");
    String reqPrenom = "SELECT userPrenom FROM user where userNumetu="+user+" or userMail ="+user;
    String resultPrenom = databaseInteraction.DatabaseRequest(reqPrenom, "userPrenom");
    String reqMail = "SELECT usermail FROM user where userNumetu="+user+" or userMail ="+user;
    String resultMail = databaseInteraction.DatabaseRequest(reqMail, "userMail");
    String reqStatut = "SELECT statut FROM user where userNumetu="+user+" or userMail ="+user;
    String resultStatut = databaseInteraction.DatabaseRequest(reqStatut, "statut");
    String reqfiliere = "SELECT filiere.nom FROM filiere\n" +
            "INNER JOIN user  ON user.idFiliere=filiere.idFiliere\n" +
            "WHERE user.userNumEtu=\""+user+"\" OR user.userMail=\""+user+"\"";
    String resultFiliere = databaseInteraction.DatabaseRequest(reqfiliere, "nom");

    public profile() throws SQLException, ClassNotFoundException {}

    //initialisation des affichage au demarage du controller
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelNumEtu.setText(resultNumEtu);
        labelNom.setText(resultNom);
        labelPrenom.setText(resultPrenom);
        labelMail.setText(resultMail);
        labelFiliere.setText(resultFiliere);
        labelStatut.setText(resultStatut);


    }


}
