import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Combobox extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        javafx.scene.control.ComboBox<Color> cmb = new javafx.scene.control.ComboBox<>();
        cmb.getItems().addAll(
            Color.RED,
            Color.GREEN,
            Color.BLUE);

        cmb.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
            @Override public ListCell<Color> call(ListView<Color> p) {
                return new ListCell<Color>() {
                    private final Rectangle rectangle;
                    {
                        setContentDisplay((ContentDisplay.GRAPHIC_ONLY));
                        rectangle = new Rectangle(10, 10);
                    }

                    @Override protected void updateItem(Color item, boolean empty) {
                        super.updateItem(item, empty);

                        if ( item == null || empty) {
                            setGraphic(null);
                        } else {
                            rectangle.setFill(item);
                            setGraphic(rectangle);
                        }
                    }
                };
            }
        });

        StackPane root = new StackPane();   // Create a StackPane layout
        root.getChildren().add(cmb);        // Create a scene
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);       // Add scene to stage
        primaryStage.show();                // basic JavaFX window
    }

    public static void main(String[] args) {

        launch(args);
    }
}
