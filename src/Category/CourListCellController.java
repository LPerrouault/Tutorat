package Category;

import Database.DatabaseInteraction;
import com.jfoenix.controls.JFXButton;
import fun.Cours;
import fun.UserQueries;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourListCellController extends HBox{

    @FXML
    HBox HboxRoot;
    @FXML
    javafx.scene.control.Label labelNom,labelDate,labelHeur,labelSalle;
    @FXML
    JFXButton buttonModif,buttonDesins;

    private UserQueries userQueries;
    private DatabaseInteraction database;
    private Cours cours;
    private ArrayList<Cours> listCours;

    public CourListCellController() throws SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface/category/courListCell.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

        this.userQueries = new UserQueries();
        this.cours = new Cours();
        this.listCours = new ArrayList<>();
        this.database = new DatabaseInteraction();
    }


    public void coursList() throws SQLException {
        listCours = userQueries.getListeCours(database.lastUserConnected());
        for (Cours c:listCours){
            labelNom.setText(String.valueOf(c.courList.get(0)));
            labelDate.setText(c.courList.get(1));
            labelHeur.setText(c.courList.get(2));
            labelSalle.setText(c.courList.get(3));
        }
    }

    public void setInfo(String string) { }

    public void setLabelNom(Label labelNom) {
        this.labelNom = labelNom;
    }

    public void setLabelDate(Label labelDate) {
        this.labelDate = labelDate;
    }

    public void setLabelHeur(Label labelHeur) {
        this.labelHeur = labelHeur;
    }

    public void setLabelSalle(Label labelSalle) {
        this.labelSalle = labelSalle;
    }

    public void Bmodifier(MouseEvent mouseEvent) {
    }

    public void Bdesinscrire(MouseEvent mouseEvent) {
    }
}
