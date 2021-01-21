package Category;

import Database.DatabaseInteraction;
import com.jfoenix.controls.JFXTimePicker;
import fun.XMLRedirection;
import fun.UserQueries;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.sql.SQLException;

public class choixCreneau {
    @FXML
    BorderPane Home;
    @FXML
    public TextField Cmatiere,Csalle,CnbEleve,Cname;
    @FXML
    MenuButton menuButton;
    @FXML
    public DatePicker Cdate;
    @FXML
    public JFXTimePicker Ctime;
    @FXML
    public TextArea Cdescriptif;
    @FXML
    private Label errorLabel;

    DatabaseInteraction data;
    UserQueries userQueries = new UserQueries();
    XMLRedirection function = new XMLRedirection();

    public choixCreneau() throws SQLException, ClassNotFoundException {
        data = new DatabaseInteraction();
    }


    public void CrenaeauAction(MouseEvent mouseEvent) throws SQLException {
        //si le premier chant nom est vide aucune action est effectué
        if (!Cname.getText().isEmpty()) {
            //Préparation et envoyer d'une requête pour permettre d'effectuer la vérification et
            // empêcher les doublons de non de matières dans la table
            String statut = "SELECT nom FROM matiere WHERE nom =\"" + Cmatiere.getText()+"\"";
            String matiereVerification = data.DatabaseRequest(statut, "nom");
            //Préparation et envoi d'une requête pour permettre de connaître l'id de la table matière ou se trouve le nom
            //Ensuite on le transforme au format int et aussi le champ CnbEleve
            String idMatiere = "SELECT idmatiere FROM matiere WHERE nom =\"" + Cmatiere.getText()+"\"";
            int idMatiereReq = Integer.parseInt(data.DatabaseRequest(idMatiere, "idmatiere"));
            int nbeleve = Integer.parseInt(CnbEleve.getText());

            //Vérification que le nom de la matière correspond bien a un nom connu dans la table matière.
            //si la verification echoue message d'erreur s'effectue
            if (matiereVerification.equals(Cmatiere.getText())) {
                //Ajout du cour dans la tablee cour avec les diferentes information
                String req = "INSERT INTO `cours` (`nom`, `date`,`heur`, `salle`, `nbEleveMax`, `descriptif`, `idmatiere`, `idResponsable`) VALUES" +
                        "( \'"+Cname.getText()+"\', \'"+Cdate.getValue()+"\', \'"+Ctime.getValue()+"\', \'"+Csalle.getText()+"\', "+nbeleve+", " +
                        "\'"+Cdescriptif.getText()+"\', "+idMatiereReq+",\'"+data.lastUserConnected()+"\')";

                 data.DatabaseUpdate(req);
                //Redirection sur la page Choix Créneaux
                String retourChoixCreneaux = "Interface/category/choixCreneau.fxml";
                Parent root = function.loadFXMLFills(retourChoixCreneaux);
                Home.setRight(root);
            } else
                errorLabel.setText("Cette Matiere n'existe pas.");
            errorLabel.setTextFill(Color.RED);
            }

    }

}
