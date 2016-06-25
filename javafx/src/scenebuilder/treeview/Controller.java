package scenebuilder.treeview;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller implements Initializable {

    @FXML
    TreeView<String> treeView;

    Image icon = new Image(getClass().getResourceAsStream("folder.png"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> root = new TreeItem<>("Root", new ImageView(icon));
        root.setExpanded(true);

        TreeItem<String> nodeA = new TreeItem<>("nodeA", new ImageView(icon));

        TreeItem<String> nodeB = new TreeItem<>("nodeB", new ImageView(icon));
        TreeItem<String> nodeC = new TreeItem<>("nodeC", new ImageView(icon));
        root.getChildren().addAll(nodeA, nodeB, nodeC);
        nodeA.setExpanded(true);

        TreeItem<String> nodeA1 = new TreeItem<>("nodeA1", new ImageView(icon));
        TreeItem<String> nodeB1 = new TreeItem<>("nodeB1", new ImageView(icon));
        TreeItem<String> nodeC1 = new TreeItem<>("nodeC1", new ImageView(icon));
        nodeA.getChildren().addAll(nodeA1, nodeB1, nodeC1);

        treeView.setRoot(root);
    }

    public void mouseClick(MouseEvent event) {

        if (event.getClickCount() == 2) {
            TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
            System.out.println(item.getValue());
        }
    }
}
