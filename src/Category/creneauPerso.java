package Category;

import Database.DatabaseInteraction;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class creneauPerso {
    @FXML
    public TextField Cname,Cmatiere,Csalle,CnbEleve;
    @FXML
    public DatePicker Cdate;
    @FXML
    public JFXTimePicker Ctime;
    @FXML
    public TextArea Cdescriptif;

    DatabaseInteraction data;

    public creneauPerso() throws SQLException, ClassNotFoundException {
        data = new DatabaseInteraction();
    }

    public void CrenaeauAction(MouseEvent mouseEvent) {
        String req ="UPDATE cours SET nom =\""+Cname+"\", date =\""+Cdate+"\"";
    }
}
