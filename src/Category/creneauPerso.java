package Category;

import Database.DatabaseInteraction;
import com.jfoenix.controls.JFXTimePicker;
import fun.CommunFunction;
import fun.UserQueries;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class creneauPerso {
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
    CommunFunction function = new CommunFunction();

    public creneauPerso() throws SQLException, ClassNotFoundException {
        data = new DatabaseInteraction();
    }


    public void CrenaeauAction(MouseEvent mouseEvent) throws SQLException {
        if (!Cname.getText().isEmpty()) {
            String statut = "SELECT nom FROM matiere WHERE nom =\"" + Cmatiere.getText()+"\"";
            String matiereVerification = data.DatabaseRequest(statut, "nom");
            String idMatiere = "SELECT idmatiere FROM matiere WHERE nom =\"" + Cmatiere.getText()+"\"";
            int idMatiereReq = Integer.parseInt(data.DatabaseRequest(idMatiere, "idmatiere"));
            int nbeleve = Integer.parseInt(CnbEleve.getText());

            if (matiereVerification.equals(Cmatiere.getText())) {
                String req = "INSERT INTO `cours` (`nom`, `date`, `salle`, `nbEleveMax`, `descriptif`, `idmatiere`, `idResponsable`) VALUES" +
                        "( \'"+Cname.getText()+"\', \'"+Cdate.getValue()+"\', \'"+Csalle.getText()+"\', "+nbeleve+", \'"+Cdescriptif.getText()+"\', "+idMatiereReq+",\'"+data.lastUserConnected()+"\')";

                 data.DatabaseUpdate(req);

                String retourChoixCreneaux = "../Interface/category/choixCreneaux.fxml";
                Parent root = function.loadFXMLFills(retourChoixCreneaux);
                Home.setRight(root);
            } else
                errorLabel.setText("Cette Matiere n'existe pas.");
            errorLabel.setTextFill(Color.RED);
            }
    }

}
