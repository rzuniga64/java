package sqlite;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type User controller. Controls the window that opens when the user logs in successfully.
 */
public class UserController implements Initializable {

    @FXML private Label username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * This method gets the user name from the login window.
     *
     * @param user the user
     */
    void getUser(String user) {

        username.setText(user);
    }

    /**
     * This method opens the login window
     *
     * @param event the event
     */
    public void signOut(ActionEvent event) {

        try {
            // hide the login window if login successful
            ((Node)event.getSource()).getScene().getWindow().hide();

            // open User window
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("login.fxml").openStream());
            primaryStage.setTitle("SQLite Example");
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
