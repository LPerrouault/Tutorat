package Database;

import User.EtuInterfaceController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

class LoginController implements  Initializable {


    @FXML
    private javafx.scene.control.Label messageConnection;
    @FXML
    private ImageView brandingImageView;
    @FXML
    public javafx.scene.control.TextField TexfieldIdentifiant;
    @FXML
    public javafx.scene.control.PasswordField PasswordField;
    @FXML
    private Button loginButton;
    @FXML
    private Hyperlink linkFogetPassword;
    private String fogerPasslink ="https://multipass.univ-tours.fr/activation.php";;


    @Override
    //initialisation des resources au demarrage
    //ici image
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("image/bd_bas_2018.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }
    //lien mots de passe oublie, avec redirection sur la page officiel mots de passe perdu de l'ENT
    //sur navigateur par  default de la macgine
    public void linkAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(fogerPasslink));
    }

    //connection etablie redirection vers les espace des utilisateurs
    public void loginAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        DatabaseInteraction dataInterac = new DatabaseInteraction();
            if (TexfieldIdentifiant.getText().isEmpty() == false && PasswordField.getText().isEmpty() == false) {
                dataInterac.validationLogin(TexfieldIdentifiant.getText(),PasswordField.getText());
                switch (dataInterac.getStatutConnection(TexfieldIdentifiant.getText(),PasswordField.getText())) {
                    case "Etudiant": {
                        //interface Etudiant
                        Parent root = FXMLLoader.load(getClass().getResource("../Interface/EtuInterface.fxml"));
                        Stage window = (Stage) loginButton.getScene().getWindow();
                        window.setScene(new Scene(root, 1180, 700));
                    }
                    break;

                    case "EtudiantTuteur": {
                        //Interface Etudiant Tuteur
                        Parent root = FXMLLoader.load(getClass().getResource("../Interface/EtuTutInterface.fxml"));
                        Stage window = (Stage) loginButton.getScene().getWindow();
                        window.setScene(new Scene(root, 1180, 700));
                    }
                    break;

                    case "Tuteur": {
                        //Interface Tuteur
                        Parent root = FXMLLoader.load(getClass().getResource("../Interface/TuteurInterface.fxml"));
                        Stage window = (Stage) loginButton.getScene().getWindow();
                        window.setScene(new Scene(root, 1180, 700));
                    }
                }
            } else {
                //erreur la verification a echoué
                messageConnection.setText("Mots de passe ou identifiant invalide");
            }
    }
}
