package imageview;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // load the image
        Image image = new Image("imageview/flower.jpg");

        // display image as is
        ImageView iv1 = new ImageView();
        iv1.setImage(image);

        // resize theimage to have width of 100 while preserving the ratio and using higher quality filtering method;
        // this ImageView is also cached to improve the performance
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(100);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);

        // define a viewport onto the source image (achieving a "zoom" effect) and displays it rotated
        ImageView iv3 = new ImageView();
        iv3.setImage(image);
        Rectangle2D viewportRect = new Rectangle2D(40, 35, 110, 110);
        iv3.setViewport(viewportRect);
        iv3.setRotate(90);

        HBox box = new HBox();
        box.getChildren().add(iv1);
        box.getChildren().add(iv2);
        box.getChildren().add(iv3);

        Group root = new Group();
        root.getChildren().add(box);
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);

        primaryStage.setTitle("ImageView");
        primaryStage.setWidth(415);
        primaryStage.setHeight(200);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();;
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
