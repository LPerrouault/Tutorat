package User;

import com.jfoenix.controls.JFXButton;
import fun.CommunFunction;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EtuTutInterfaceController implements Initializable {
    @FXML
    private ImageView brandingImageView;
    @FXML
    BorderPane Home;
    @FXML
    JFXButton deconnectionButton;
    @FXML
    private JFXButton emploieDuTempsCategory,inscriptionCategory, mesCoursCategory, devenirTuteurCategory,espaceTuteurCategory;
    @FXML
    private VBox PaneEmploie, PaneInscription, PaneCours, PaneDTuteur,PaneProfile, PaneParametre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("image/bd_bas_2018.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
        loadCat("emploieDuTemps");
    }

    private void loadCat(String cat){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Interface/category/"+cat+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Home.setCenter(root);
    }

    public void EDTCat(MouseEvent mouseEvent) {
        loadCat("emploieDuTemps");
    }

    public void inscriptionCat(javafx.scene.input.MouseEvent mouseEvent) {
        loadCat("inscription");
    }

    public void coursCat(MouseEvent mouseEvent) {
        loadCat("mesCours");
    }

    public void EspaceTutCat(MouseEvent mouseEvent) {
        loadCat("espaceTuteur");
    }

    public void profilCat(MouseEvent mouseEvent) {
        loadCat("profile");
    }

    public void paramettreCat(MouseEvent mouseEvent) {
        loadCat("paramettre");
    }

    public void deconectionBTN(MouseEvent mouseEvent) throws IOException {
        CommunFunction function = new CommunFunction();
        Stage stage = (Stage) deconnectionButton.getScene().getWindow();
        stage.close();
        Platform.runLater(() -> {
                    String login = "../Interface/login.fxml";
                    Parent root = function.loadFXMLFills(login);
                }
        );

    }



}
