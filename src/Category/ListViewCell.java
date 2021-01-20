package Category;

import Database.DatabaseInteraction;
import fun.Cours;
import fun.UserQueries;
import javafx.scene.control.ListCell;

import java.sql.SQLException;
import java.util.ArrayList;

public class ListViewCell extends ListCell<String> {
    private final CourListCellController data;

    public ListViewCell() throws SQLException, ClassNotFoundException {
        this.data = new CourListCellController();
        setGraphic(this.data);
    }

    @Override
    public void updateItem(String string, boolean empty) {
        super.updateItem(string, empty);

        data.setInfo(string == null ? "AAAA" : string);
    }

}
