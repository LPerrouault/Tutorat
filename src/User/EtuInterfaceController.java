package User;

import Menu.MenuInteraction;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EtuInterfaceController implements Initializable  {
    @FXML
    private ImageView brandingImageView;
    @FXML
    private JFXButton emploieDuTempsCategory,inscriptionCategory, mesCoursCategory, devenirTuteurCategory,espaceTuteurCategory
            , profileButton, deconnectionButton, parametreButton;
    @FXML
    private Pane PaneEmploie, PaneInscription, PaneCours, PaneDTuteur,PaneETuteur,PaneProfile, PaneParametre;
    @FXML
    private VBox menuBar;

    public EtuInterfaceController() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
            File brandingFile = new File("image/bd_bas_2018.png");
            Image brandingImage = new Image(brandingFile.toURI().toString());
            brandingImageView.setImage(brandingImage);
    }

    public ImageView getBrandingImageView() {
        return brandingImageView;
    }

        //choix category du menu
    public void menuCategory(ActionEvent event) throws IOException {
            //Emploie du temps
            if (event.getSource().equals(emploieDuTempsCategory)){
                PaneEmploie.toFront();
            }
            //inscription a un cours
            else if (event.getSource().equals(inscriptionCategory) ){
                PaneInscription.toFront();
            }
            //Mes Cours
            else if (event.getSource().equals(mesCoursCategory)){
                PaneCours.toFront();
            }
            //Devenir Tuteur
            else if (event.getSource().equals(devenirTuteurCategory)){
                PaneDTuteur.toFront();
            }
            //Profil
            else if (event.getSource().equals(profileButton)) {
                PaneProfile.toFront();
            }
            //Paramettre
            else if (event.getSource().equals(parametreButton)){
            }
            //Deconnection de la session
            else if (event.getSource().equals(deconnectionButton) ) {
                Parent root = FXMLLoader.load(getClass().getResource("../Interface/login.fxml"));
                Stage window =(Stage) deconnectionButton.getScene().getWindow();
                window.setScene( new Scene(root,600, 500));
            }
    }
}

