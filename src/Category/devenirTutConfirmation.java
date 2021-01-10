package Category;

import Database.DatabaseInteraction;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class devenirTutConfirmation {

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

    public void Btnconfirmer(MouseEvent mouseEvent) throws SQLException {
        String user = dataInteract.lastUserConnected();
        String req = "UPDATE user SET statut = \"EtudiantTuteur\" WHERE userNumEtu = "+user+" OR userMail= "+user;
        dataInteract.DatabaseRequest(req, "statut");
    }
}
