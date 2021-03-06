package UserSpaceController;

import com.jfoenix.controls.JFXButton;

import fun.XMLRedirection;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EtuInterfaceController implements Initializable  {
    @FXML
    private ImageView brandingImageView;
    @FXML
    private BorderPane Home;
    @FXML
    JFXButton deconnectionButton;
    @FXML
    private VBox PaneEmploie, PaneInscription, PaneCours, PaneDTuteur,PaneProfile, PaneParametre;
    @FXML
    private VBox menuBar;


    public EtuInterfaceController() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("image/bd_bas_2018.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
        loadCat("emploieDuTemps");
    }

    public ImageView getBrandingImageView() {
        return brandingImageView;
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

    public void dTuteurCat(MouseEvent mouseEvent) {
        loadCat("devenirTuteur");
    }

    public void profilCat(MouseEvent mouseEvent) { loadCat("profile"); }

    public void deconectionBTN(MouseEvent mouseEvent) throws IOException {
        XMLRedirection function = new XMLRedirection();
        Stage stage = (Stage) deconnectionButton.getScene().getWindow();
        stage.close();

        Platform.runLater(() -> {
                    String login = "../Interface/login.fxml";
                    Parent root = function.loadFXMLFills(login);
                }
        );

    }

}