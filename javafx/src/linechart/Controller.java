package linechart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class Controller  {

    @FXML LineChart<String,Number> linechart;

    public void btn(ActionEvent event) {

        linechart.getData().clear();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Jan", 200));
        series.getData().add(new XYChart.Data<>("Feb", 500));
        series.getData().add(new XYChart.Data<>("Mar", 300));
        series.getData().add(new XYChart.Data<>("Apr", 600));

        series.setName("Monthly Pay");
        linechart.getData().add(series);
    }
}
