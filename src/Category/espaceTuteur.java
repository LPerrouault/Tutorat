package Category;

import Database.DatabaseInteraction;
import User.EtuInterfaceController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class espaceTuteur implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    private void loadCat(String cat){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Interface/category/"+cat+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void emploieDuTempsRedirection(ActionEvent event) {
        loadCat("emploieDuTemps");
    }

    public void mesCoursRedirection(ActionEvent event) {
        loadCat("mesCours");
    }

    public void ChoisirCreneaux(ActionEvent event) {
        loadCat("choixCreneaux");
    }

    public void plusEtreTuteur(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        DatabaseInteraction dataInteract = new DatabaseInteraction();
        String user = dataInteract.lastUserConnected();
        String req = "UPDATE user SET statut = \"Etudiant\"  WHERE userNumEtu = \""+user+"\" OR userMail = \""+user+"\" ";
        dataInteract.DatabaseUpdate(req);
    }




}
