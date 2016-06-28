package mediaplayer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private MediaView mediaview;
    @FXML private MediaPlayer mediaplayer;
    @FXML private Media media;

    @FXML Slider volumeSlider;

    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String path = new File("javafx/src/mediaplayer/media/bunny.mp4").getAbsolutePath();

        media = new Media(new File(path).toURI().toString());
        mediaplayer = new MediaPlayer(media);
        mediaview.setMediaPlayer(mediaplayer);
        mediaplayer.setAutoPlay(true);
        DoubleProperty width = mediaview.fitWidthProperty();
        DoubleProperty height = mediaview.fitHeightProperty();
        width.bind(Bindings.selectDouble(mediaview.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaview.sceneProperty(), "height"));

        volumeSlider.setValue(mediaplayer.getVolume()* 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaplayer.setVolume(volumeSlider.getValue()/100);
            }
        });
    }

    public void play(ActionEvent event){
        mediaplayer.setRate(1.0);
        mediaplayer.play();
    }

    public void pause(ActionEvent event){
        mediaplayer.pause();
    }

    public void fast(ActionEvent event){
        mediaplayer.setRate(2.0);
    }

    public void slow(ActionEvent event){
        mediaplayer.setRate(0.5);
    }

    public void reload(ActionEvent event){
        mediaplayer.seek(mediaplayer.getStartTime());
        mediaplayer.play();
    }

    public void start(ActionEvent event){
        mediaplayer.seek(mediaplayer.getStartTime());
        mediaplayer.stop();
    }

    public void last(ActionEvent event){
        mediaplayer.seek(mediaplayer.getTotalDuration());
        mediaplayer.stop();
    }
}
