package Category;

import Database.DatabaseInteraction;
import fun.XMLRedirection;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;


public class espaceTuteur {
    @FXML
    BorderPane Home;
    @FXML
    private VBox CcreneauxVbox;

    XMLRedirection function;

    public espaceTuteur() {
         function = new XMLRedirection();
    }

    //redirection vers l'emploie du temps
    public void emploieDuTempsRedirection(MouseEvent mouseEvent) throws IOException {
        String emploieDuTemps = "../Interface/category/emploieDuTemps.fxml";
        Parent root = function.loadFXMLFills(emploieDuTemps);
        Home.setRight(root);

    }
    //redirection ver mes cours
    public void mesCoursRedirection(MouseEvent mouseEvent) throws IOException {
        String mesCours = "../Interface/category/mesCours.fxml";
        Parent root = function.loadFXMLFills(mesCours);
        Home.setRight(root);
    }

    //redirection vers choix de creneau
    public void ChoisirCreneaux(MouseEvent mouseEvent) throws IOException {
        String choixCreneaux = "../Interface/category/choixCreneau.fxml";
        Parent root = function.loadFXMLFills(choixCreneaux);
        Home.setRight(root);
    }

    //requete permetant a un etudiant tuteur de redevenir etudiant classique
    public void plusEtreTuteur(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        DatabaseInteraction dataInteract = new DatabaseInteraction();
        String login = "../Interface/login.fxml";
        String user = dataInteract.lastUserConnected();
        String req = "UPDATE user SET statut = \"Etudiant\"  WHERE userNumEtu = \""+user+"\" OR userMail = \""+user+"\" ";
        dataInteract.DatabaseUpdate(req);
        function.loadFXMLFills(login);
    }
}
