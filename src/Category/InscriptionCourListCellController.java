package Category;

import Database.DatabaseInteraction;
import com.jfoenix.controls.JFXButton;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import fun.Cours;
import fun.UserQueries;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



public class InscriptionCourListCellController extends VBox{


    @FXML
    JFXButton ButtonsInscrip;
    @FXML
    javafx.scene.control.Label labelNom,labelDate,labelHeur,labelSalle;

    private UserQueries userQueries = new UserQueries();
    private DatabaseInteraction database = new DatabaseInteraction();;



    public InscriptionCourListCellController() throws SQLException, ClassNotFoundException {
    }

}
