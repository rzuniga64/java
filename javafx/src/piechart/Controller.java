package piechart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private PieChart piechart;
    @FXML private Label status;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void btn(ActionEvent event) {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Java", 50),
                new PieChart.Data("C++", 20),
                new PieChart.Data("Python", 30),
                new PieChart.Data("C#", 10),
                new PieChart.Data("C", 15)
        );

        piechart.setData(list);

        for (final PieChart.Data data : piechart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    status.setText(String.valueOf(data.getPieValue()) + "%");
                }
            });
        }
    }
}
