package Category;

import fun.CommunFunction;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class choixCreneaux {
    CommunFunction function;

    public choixCreneaux() {
        function = new CommunFunction();
    }

    public void Cperso(MouseEvent mouseEvent) {
        String Cperso = "../Interface/category/CreneauPersonalise.fxml";
    }

    public void Cauto(MouseEvent mouseEvent) {
        String Cauto = "../Interface/category/CreneauAutomatique.fxml";
    }
}
