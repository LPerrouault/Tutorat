package Category;

import Database.DatabaseInteraction;
import com.jfoenix.controls.JFXButton;
import fun.Cours;
import fun.UserQueries;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class inscription{
    @FXML
    private MenuButton menuMatiere;
    @FXML
    private JFXButton valider;
    @FXML
    private VBox coursList;
    @FXML
    HBox HboxRoot;
    @FXML
    javafx.scene.control.Label labelNom,labelDate,labelHeur,labelSalle;

    DatabaseInteraction databaseInteraction;
    UserQueries userQueries;
    ArrayList<MenuItem> listItemMatiere = new ArrayList<>();
    ArrayList<Parent> listItemCours = new ArrayList<>();
    String matiereValue;


    public inscription() throws SQLException, ClassNotFoundException {
        databaseInteraction = new DatabaseInteraction();
        userQueries = new UserQueries();
        listItemMatiere.clear();
        listItemCours.clear();
    }


    //Choix des matiéres dans le défilant avec un enregistrement de la valeur lors que
    //l'on selectionne la matiere choisie
    public void generationList(MouseEvent mouseEvent) throws SQLException {
        MenuItem menuItem = null;
        if (listItemMatiere.isEmpty()){
            for (String matiere: userQueries.affichageMatiere()) {
                if (listItemMatiere.size() < userQueries.affichageMatiere().size()){
                    menuItem = new MenuItem(matiere);
                    listItemMatiere.add(menuItem);
                    menuMatiere.getItems().add(menuItem);
                    MenuItem finalMenuItem = menuItem;
                    menuItem.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            matiereValue = finalMenuItem.getText();
                            menuMatiere.setText(finalMenuItem.getText());
                        }
                    });
                }
            }
        }
    }

    //methode effectuant une liste par l'intermediaire du fichier courListcell.fxml
    public void validationCours(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        coursList.getChildren().clear();

        for (Cours c:userQueries.affichageInscriptionCours(matiereValue)){
            loadCat();
        }
    }

    //mathode permetant de load le fichier courListcell.fxml dans la Vbox cours liste
    private void loadCat() throws SQLException, ClassNotFoundException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interface/category/coursInscription.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        coursList.getChildren().add(root);
        listItemCours.add(root);
    }

    public String getMatiereValue() {
        return matiereValue;
    }

    public void setMatiereValue(String matiereValue) {
        this.matiereValue = matiereValue;
    }
}
