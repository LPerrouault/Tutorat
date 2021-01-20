package Category;

import Database.DatabaseInteraction;
import com.jfoenix.controls.JFXButton;
import fun.Cours;
import fun.UserQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class mesCours implements Initializable {


    @FXML
    private ListView<String> listCours;

    private ObservableList observableList = FXCollections.observableArrayList();;
    private CourListCellController listCellController;
    private ArrayList<String> list = new ArrayList<>();



    public mesCours() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coursList();
    }

    public void coursList(){
        observableList.removeAll(observableList);
        String a ="bonjour";
        String b ="bonjour";
        String c ="bonjour";
        String d ="bonjour";
        observableList.addAll(a,b,c,d);
        listCours.getItems().addAll(observableList);
    }

    public void desinscrire(MouseEvent mouseEvent) { }

    public void modifierCreneaux(MouseEvent mouseEvent) { }



}
