package sqlite;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * The type Login controller.
 */
public class LoginController implements Initializable {

    private LoginModel loginModel = new LoginModel();

    @FXML private Label isConnected;
    @FXML private TextField username;
    @FXML private TextField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (loginModel.isDbConnected()) {
            isConnected.setText("Connected");
        } else
            isConnected.setText("Not Connected");
    }

    /**
     * Login. When the user successfully logs in another page is displayed with the user's name.
     *
     * @param event the event
     */
    public void Login(ActionEvent event) {
        try {
            if (loginModel.isLogin(username.getText(), password.getText())) {
                isConnected.setText("username and password is correct");

                // hide the login window if login successful
                ((Node)event.getSource()).getScene().getWindow().hide();

                // open User window
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("user.fxml").openStream());
                UserController userController = loader.getController();
                userController.getUser(username.getText());

                primaryStage.setTitle("SQLite Example");
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                isConnected.setText("username and password is not correct");
            }
        } catch (SQLException e) {
            isConnected.setText("username and password is not correct");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
