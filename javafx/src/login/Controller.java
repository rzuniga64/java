package login;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
    private Text actiontarget;
    private TextField userTextField;
    private PasswordField pwbox;

    Controller( Text actiontarget, TextField userTextField, PasswordField pwbox) {
        this.actiontarget = actiontarget;
        this.userTextField = userTextField;
        this.pwbox = pwbox;
    }

    public void Login(ActionEvent event) {
        actiontarget.setFill(Color.FIREBRICK);
        if (userTextField.getText().equals("rzuniga64") && pwbox.getText().equals("aggies92")) {
            actiontarget.setText("Sign in button pressed");

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            // Title
            Text sceneTitle = new Text("Welcome");
            sceneTitle.setFont(Font.font("Helvetica", FontWeight.NORMAL, 20));
            grid.add(sceneTitle, 0, 0, 2, 1);

            Scene scene = new Scene(grid, 300, 275);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            actiontarget.setText("Login Failed");
        }
    }
}
