import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class HelloWorld extends Application {
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
        StackPane root = new StackPane();   // Create a StackPane layout
        root.getChildren().add(btn);        // Create a scene
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);       // Add scene to stage
        primaryStage.show();                // basic JavaFX window
    }
}

