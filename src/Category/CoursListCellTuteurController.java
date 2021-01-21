package Category;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.awt.*;

public class CoursListCellTuteurController extends VBox {
    @FXML
    public JFXButton buttonModifier;
    @FXML
    public JFXButton buttonSupprimer;
    @FXML
    Label labelName, labelDate, labelHeur,labelSalle;

    public void BModifier(MouseEvent mouseEvent) {
    }

    public void BSupprimer(MouseEvent mouseEvent) {
    }
}
