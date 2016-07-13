package sqlite;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

    public void Login(ActionEvent event) {
        try {
            if (loginModel.isLogin(username.getText(), password.getText())) {
                isConnected.setText("username and password is correct");
            } else {
                isConnected.setText("username and password is not correct");
            }
        } catch (SQLException e) {
            isConnected.setText("username and password is not correct");
            e.printStackTrace();
        }
    }
}
