package Category;

import fun.Cours;
import fun.UserQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class mesCours implements Initializable {

    @FXML
    public VBox coursList;

    private ArrayList<Cours> listCourTuteur = new ArrayList<>();
    UserQueries userQueries;

    public mesCours() throws SQLException, ClassNotFoundException {
        userQueries = new UserQueries();
        listCourTuteur.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            affichageCoursTuteurEtudiant();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void affichageCoursTuteurEtudiant() throws SQLException, ClassNotFoundException {

        for (Cours cours: userQueries.affichageCoursTuteur()){
            coursTuteur();
        }

        for (Cours cours: userQueries.affichageCours()){
            coursEtudiant();
        }
    }

    private void coursTuteur() throws SQLException, ClassNotFoundException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interface/category/courListCellTuteur.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        coursList.getChildren().add(root);
    }

    private void coursEtudiant() throws SQLException, ClassNotFoundException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interface/category/coursListCell.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        coursList.getChildren().add(root);
    }

}
