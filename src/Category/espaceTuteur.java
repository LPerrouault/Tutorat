package Category;

import Database.DatabaseInteraction;
import User.EtuInterfaceController;
import fun.CommunFunction;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class espaceTuteur {
    CommunFunction function;

    public espaceTuteur() {
         function = new CommunFunction();
    }

    public void emploieDuTempsRedirection(MouseEvent mouseEvent) throws IOException {
       /* String emploieDuTemps = "../Interface/category/emploieDuTemps.fxml";
        function.loadFXMLFills(emploieDuTemps);*/
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Interface/category/emploieDuTemps.fxml"));
    }

    public void mesCoursRedirection(MouseEvent mouseEvent) throws IOException {
        /*String mesCours = "../Interface/category/mesCours.fxml";
        function.loadFXMLFills(mesCours);*/
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Interface/category/mesCours.fxml"));
    }

    public void ChoisirCreneaux(MouseEvent mouseEvent) throws IOException {
        /*String choixCreneaux = ;
        function.loadFXMLFills(choixCreneaux);*/
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Interface/category/choixCreneaux.fxml"));
    }

    public void plusEtreTuteur(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        DatabaseInteraction dataInteract = new DatabaseInteraction();
        String login = "../Interface/login.fxml";
        String user = dataInteract.lastUserConnected();
        String req = "UPDATE user SET statut = \"Etudiant\"  WHERE userNumEtu = \""+user+"\" OR userMail = \""+user+"\" ";
        dataInteract.DatabaseUpdate(req);
        function.loadFXMLFills(login);
    }
}
