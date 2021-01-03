package Menu;

import Database.DatabaseInteraction;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.awt.event.ActionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class MenuInteraction  extends JFXButton {
    @FXML
    private JFXButton emploieDuTempsCategory,inscriptionCategory, mesCoursCategory, devenirTuteurCategory,espaceTuteurCategory
            , profileButton, deconnectionButton, parametreButton;
    @FXML
    private Pane PaneEmploie, PaneInscription, PaneCours, PaneDTuteur,PaneETuteur,PaneProfile, PaneParametre;

    Principal menu;
    DatabaseInteraction dataInteract = new DatabaseInteraction();

    public MenuInteraction() throws SQLException, ClassNotFoundException {
    }

    public void menuEtudiant(ActionEvent event) throws IOException {

        if (dataInteract.getUserStatut().equals("Etudiant")){
            if (event.equals(emploieDuTempsCategory)){
                PaneEmploie.toFront();
            }
            //inscription a un cours
            else if (devenirTuteurCategory.equals(inscriptionCategory) ){
                PaneInscription.toFront();
            }
            //Mes Cours
            else if (devenirTuteurCategory.equals(mesCoursCategory)){
                PaneCours.toFront();
            }
            //Devenir Tuteur
            else if (devenirTuteurCategory.equals(devenirTuteurCategory)){
                PaneDTuteur.toFront();
            }
            //Profil
            else if (devenirTuteurCategory.equals(profileButton)) {
                PaneProfile.toFront();
            }
            //Paramettre
            else if (devenirTuteurCategory.equals(parametreButton)){
            }
            //Deconnection de la session
            else if (devenirTuteurCategory.equals(deconnectionButton)) {
                dataInteract.getUserStatut().clear();
                Parent root = FXMLLoader.load(getClass().getResource("../Interface/login.fxml"));
                Stage window =(Stage) deconnectionButton.getScene().getWindow();
                window.setScene( new Scene(root,600, 500));
            }

        }
    }

    public void menuEtudiantTuteur(ActionListener listener) throws IOException {

        if (dataInteract.getUserStatut().equals("EtudiantTuteur")){
            if (listener.equals(emploieDuTempsCategory)){
                PaneEmploie.toFront();
            }
            //inscription a un cours
            else if (listener.equals(inscriptionCategory) ){
                PaneInscription.toFront();
            }
            //Mes Cours
            else if (listener.equals(mesCoursCategory)){
                PaneCours.toFront();
            }
            //espaceTuteur
            else if (listener.equals( espaceTuteurCategory)){
                PaneDTuteur.toFront();
            }
            //Profil
            else if (listener.equals(profileButton)) {
                PaneProfile.toFront();
            }
            //Paramettre
            else if (listener.equals(parametreButton)){
            }
            //Deconnection de la session
            else if (listener.equals(deconnectionButton)) {
                dataInteract.getUserStatut().clear();
                Parent root = FXMLLoader.load(getClass().getResource("../Interface/login.fxml"));
                Stage window =(Stage) deconnectionButton.getScene().getWindow();
                window.setScene( new Scene(root,600, 500));
            }

        }
    }

    public void menuTuteur(ActionListener listener) throws IOException {
        if (dataInteract.getUserStatut().equals("Tuteur")){
            if (listener.equals(emploieDuTempsCategory)){
                PaneEmploie.toFront();
            }
            //Mes Cours
            else if (listener.equals(mesCoursCategory)){
                PaneCours.toFront();
            }
            //espaceTuteur
            else if (listener.equals( espaceTuteurCategory)){
                PaneDTuteur.toFront();
            }
            //Profil
            else if (listener.equals(profileButton)) {
                PaneProfile.toFront();
            }
            //Paramettre
            else if (listener.equals(parametreButton)){
            }
            //Deconnection de la session
            else if (listener.equals(deconnectionButton)) {
                dataInteract.getUserStatut().clear();
                Parent root = FXMLLoader.load(getClass().getResource("../Interface/login.fxml"));
                Stage window =(Stage) deconnectionButton.getScene().getWindow();
                window.setScene( new Scene(root,600, 500));
            }
        }
    }




}
