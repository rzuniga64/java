package scenebuilder.filechooser;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller implements Initializable {

    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private ListView listview;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void Button1Action(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\Owner\\Documents"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            listview.getItems().add(selectedFile.getAbsolutePath());
        } else {
            System.out.println("File is not valid");
        }
    }

    public void button2Action(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\Owner\\Documents"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);

        if (selectedFiles != null) {
            for (int i = 0; i < selectedFiles.size(); i++) {
                listview.getItems().add(selectedFiles.get(i).getAbsolutePath());
            }
        } else {
            System.out.println("File is not valid");
        }
    }
}
