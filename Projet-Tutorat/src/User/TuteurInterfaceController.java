package User;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TuteurInterfaceController implements Initializable {
    @FXML
    private ImageView brandingImageView;
    @FXML
    private JFXButton emploieDuTempsCategory,inscriptionCategory, mesCoursCategory, devenirTuteurCategory,espaceTuteurCategory,
    profileButton, parametreButton, deconnectionButon;

    @FXML
    private Pane PaneEmploie, PaneInscription, PaneCours, PaneDTuteur,PaneETuteur,PaneProfile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("image/bd_bas_2018.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }

    public void ChoixCategory(ActionEvent event) {
        if (event.getSource() == emploieDuTempsCategory){
            PaneEmploie.toFront();
        }
        else if (event.getSource() == inscriptionCategory ){
            PaneInscription.toFront();
        }
        else if (event.getSource() == mesCoursCategory){
            PaneCours.toFront();
        }
        else if (event.getSource() == devenirTuteurCategory){
            PaneDTuteur.toFront();
        }
        else if (event.getSource() == espaceTuteurCategory){
            PaneETuteur.toFront();
        }
        else if (event.getSource() == profileButton)
            PaneProfile.toFront();
    }
}
