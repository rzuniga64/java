package scenebuilder.events;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Random;

public class Controller {
    // annotation that tags a class or memeber as accessible to markup.
    @FXML
    private Label myMessage;

    public void generateRandom(ActionEvent event) {

        Random rand = new Random();
        int myrand = rand.nextInt(50) + 1; //generate a random number between 1 and 50
        myMessage.setText(Integer.toString(myrand));
        System.out.println(Integer.toString(myrand) );
    }

    public void pressButton(ActionEvent e) {
        System.out.println("Hello World");
    }
}

