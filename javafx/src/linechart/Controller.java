package linechart;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class Controller  {

    @FXML LineChart<String,Number> linechart;
    @FXML Label lbl;

    public void btn(ActionEvent event) {

        linechart.getData().clear();

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("Jan", 200));
        series1.getData().add(new XYChart.Data<>("Feb", 500));
        series1.getData().add(new XYChart.Data<>("Mar", 300));
        series1.getData().add(new XYChart.Data<>("Apr", 600));
        series1.setName("Monthly Pay 1");

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.getData().add(new XYChart.Data<>("Jan", 400));
        series2.getData().add(new XYChart.Data<>("Feb", 100));
        series2.getData().add(new XYChart.Data<>("Mar", 800));
        series2.getData().add(new XYChart.Data<>("Apr", 500));
        series2.setName("Monthly Pay 2");

        linechart.getData().addAll(series1, series2);

        for (final XYChart.Data<String, Number> data : series1.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    lbl.setText("X : " + data.getXValue() + "\n Y : " + String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(), new Tooltip("X : " + data.getXValue() + "\n Y : " +
                            String.valueOf(data.getYValue())));
                }
            });
        }
    }
}
