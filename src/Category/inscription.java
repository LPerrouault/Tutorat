package Category;

import Database.DatabaseInteraction;
import fun.UserQueries;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class inscription implements Initializable {
    @FXML
    private MenuButton menuMatiere;

    DatabaseInteraction databaseInteraction;
    UserQueries userQueries;

    public inscription() throws SQLException, ClassNotFoundException {
        databaseInteraction = new DatabaseInteraction();
        userQueries = new UserQueries();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void menuList(){
        try {
            for (String s:userQueries.affichageMatiere()) {
                MenuItem menuItem = new MenuItem(userQueries.toString());
                menuMatiere.getItems().add(menuItem);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
