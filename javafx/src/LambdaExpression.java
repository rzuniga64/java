import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LambdaExpression extends Application {
    public static void main(String[] args) {
        // start application
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        Button btn = new Button("Click me");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });

        Button exit = new Button("Exit");
        // use a lambda expression instead of anonymous function. Calls single abstract method handle inside the
        // anonymous class.
        exit.setOnAction(e -> {
            System.out.println("Exiting");
            System.exit(0);
        });

        VBox root = new VBox();   // Create a StackPane layout
        root.getChildren().addAll(btn, exit);        // Create a scene
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("My title");
        primaryStage.setScene(scene);               // Add scene to stage
        primaryStage.show();                        // basic JavaFX window
    }
}