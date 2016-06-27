package tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TableView<Student> table;
    @FXML private TableColumn<Student, Integer> id;
    @FXML private TableColumn<Student, String> name;
    @FXML private TableColumn<Student, String> surname;
    @FXML private TableColumn<Student, Integer> age;

    public ObservableList<Student> list = FXCollections.observableArrayList(
            new Student(1, "Mark", "Smith", 22),
            new Student(1, "Tom", "Brown", 30),
            new Student(1, "Ben", "Williams", 41),
            new Student(1, "Tommy", "Jones", 33),
            new Student(1, "Jack", "Wagner", 56)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id.setCellFactory(new PropertyValueFactory<Student, Integer>("id"));
        id.setCellFactory(new PropertyValueFactory<Student, String>("name"));
        id.setCellFactory(new PropertyValueFactory<Student, String>("surname"));
        id.setCellFactory(new PropertyValueFactory<Student, Integer>("age"));

        table.setItems(list);
    }
}
