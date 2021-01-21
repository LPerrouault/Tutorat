package fun;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class XMLRedirection {

    public XMLRedirection() {
    }

    public Parent loadFXMLFills(String cat){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(cat));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }


}
