package Category;

import com.jfoenix.controls.JFXButton;
import fun.CommunFunction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class choixCreneaux {
    @FXML
    BorderPane Home;
    @FXML
    private VBox CcreneauxVbox;
    CommunFunction function;

    public choixCreneaux() {
        function = new CommunFunction();
    }

    public void Cperso(MouseEvent mouseEvent) {
        String Cperso = "../Interface/category/CreneauPersonalise.fxml";
        Parent root = function.loadFXMLFills(Cperso);
        Home.setRight(root);
    }

    public void Cauto(MouseEvent mouseEvent) {
        String Cauto = "../Interface/category/CreneauAutomatique.fxml";
        Parent root = function.loadFXMLFills(Cauto);
        Home.setRight(root);
    }
}
