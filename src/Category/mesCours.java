package Category;

import Database.DatabaseInteraction;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class mesCours implements Initializable {
    public mesCours() throws SQLException, ClassNotFoundException {
    }

    DatabaseInteraction databaseInteraction = new DatabaseInteraction();




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void ChangeCreneaux(MouseEvent mouseEvent) {
    }

    public void desinscrire(MouseEvent mouseEvent) {
    }
}
