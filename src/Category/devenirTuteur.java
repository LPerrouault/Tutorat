package Category;

import Database.DatabaseInteraction;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;

public class devenirTuteur {

    DatabaseInteraction dataInteract;
    {
        try {
            dataInteract = new DatabaseInteraction();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Requette qui change le statut dans la base pour que la personne devienne etudiant tuteur
    public void BtnEngager(ActionEvent event) throws  SQLException {
        String user = dataInteract.lastUserConnected();
        String req = "UPDATE user SET statut = \"Etudiant-Tuteur\"  WHERE userNumEtu = \""+user+"\" OR userMail = \""+user+"\" ";
        dataInteract.DatabaseUpdate(req);
    }
}
