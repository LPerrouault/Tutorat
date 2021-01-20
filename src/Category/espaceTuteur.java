package Category;

import Database.DatabaseInteraction;
import User.EtuInterfaceController;
import com.jfoenix.controls.JFXButton;
import fun.CommunFunction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class espaceTuteur {
    @FXML
    BorderPane Home;
    @FXML
    private VBox CcreneauxVbox;

    CommunFunction function;

    public espaceTuteur() {
         function = new CommunFunction();
    }

    public void emploieDuTempsRedirection(MouseEvent mouseEvent) throws IOException {
        String emploieDuTemps = "../Interface/category/emploieDuTemps.fxml";
        Parent root = function.loadFXMLFills(emploieDuTemps);
        Home.setRight(root);

    }

    public void mesCoursRedirection(MouseEvent mouseEvent) throws IOException {
        String mesCours = "../Interface/category/mesCours.fxml";
        Parent root = function.loadFXMLFills(mesCours);
        Home.setRight(root);
    }

    public void ChoisirCreneaux(MouseEvent mouseEvent) throws IOException {
        String choixCreneaux = "../Interface/category/choixCreneaux.fxml";
        Parent root = function.loadFXMLFills(choixCreneaux);
        Home.setRight(root);
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
