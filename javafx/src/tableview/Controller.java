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
            new Student(2, "Tom", "Brown", 30),
            new Student(3, "Ben", "Williams", 41),
            new Student(4, "Tommy", "Jones", 33),
            new Student(5, "Jack", "Wagner", 56)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        table.setItems(list);

        id= new TableColumn<Student, Integer>("id");
        name= new TableColumn<Student, String>("name");
        surname = new TableColumn<Student, String>("surname");
        age = new TableColumn<Student, Integer>("age");

        id.setCellValueFactory(new PropertyValueFactory("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        surname.setCellValueFactory(new PropertyValueFactory("surname"));
        age.setCellValueFactory(new PropertyValueFactory("age"));

        table.getColumns().setAll(id, name, surname, age);
    }
}
