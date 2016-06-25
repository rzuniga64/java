import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *A ListView displays a horizontal or vertical list of items from which the user may select, or with which the user may
 * interact. A ListView is able to have its generic type set to represent the type of data in the backing model.
 * Doing this has the benefit of making various methods in the ListView, as well as the supporting classes (mentioned
 * below), type-safe. In addition, making use of the generic supports substantially simplifies development of
 * applications making use of ListView, as all modern IDEs are able to auto-complete far more successfully with the
 * additional type information.
*/

public class Listview extends Application {
    public static void main(String[] args) {
        // start application
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Matthew", "Hannah", "Stephan", "Denise");
        ListView<String> listView = new ListView<String>(names);

        StackPane root = new StackPane();   // Create a StackPane layout
        root.getChildren().addAll(listView);        // Create a scene
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("My title");
        primaryStage.setScene(scene);               // Add scene to stage
        primaryStage.show();                        // basic JavaFX window
    }
}