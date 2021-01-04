package User;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private BorderPane etuHome;

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
        etuHome.setCenter(root);
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

    public void profilCat(MouseEvent mouseEvent) {
        loadCat("profile");
    }

    public void paramettreCat(MouseEvent mouseEvent) {
        loadCat("paramettre");
    }

    public void deconectionBTN(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Interface/login.fxml"));
        JFXButton deconnectionButton = new JFXButton();
        Stage window =(Stage) deconnectionButton.getScene().getWindow();
        window.setScene( new Scene(root,600, 500));
    }

//        //choix category du menu
//    public void menuCategory(javafx.scene.input.MouseEvent event) throws IOException {
//            //Emploie du temps
//            if (event.getSource().equals(emploieDuTempsCategory)){
//                PaneEmploie.toFront();
//            }
//            //inscription a un cours
//            else if (event.getSource().equals(inscriptionCategory) ){
//                PaneInscription.toFront();
//            }
//            //Mes Cours
//            else if (event.getSource().equals(mesCoursCategory)){
//                PaneCours.toFront();
//            }
//            //Devenir Tuteur
//            else if (event.getSource().equals(devenirTuteurCategory)){
//                PaneDTuteur.toFront();
//            }
//            //Profil
//            else if (event.getSource().equals(profileButton)) {
//                PaneProfile.toFront();
//            }
//            //Paramettre
//            else if (event.getSource().equals(parametreButton)){
//                PaneParametre.toFront();
//            }
//            //Deconnection de la session
//            else if (event.getSource().equals(deconnectionButton) ) {
//                Parent root = FXMLLoader.load(getClass().getResource("../Interface/login.fxml"));
//                Stage window =(Stage) deconnectionButton.getScene().getWindow();
//                window.setScene( new Scene(root,600, 500));
//            }
//    }

}