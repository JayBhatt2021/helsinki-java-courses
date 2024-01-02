import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CyclingStatisticsApplication extends Application {
    @Override
    public void start(Stage stage) {
        CyclingStatistics cyclingStatistics = new CyclingStatistics("helsinki-cycling-statistics.csv");
        ObservableList<String> locationList = FXCollections.observableArrayList();
        locationList.addAll(cyclingStatistics.locations());

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Year / Month");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Cyclists");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setLegendVisible(false);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.add(new Label("Choose the examined location"), 0, 0);

        ListView<String> listView = new ListView<>(locationList);
        gridPane.add(listView, 0, 1);

        listView.setOnMouseClicked((MouseEvent event) -> {
            String chosenLocation = listView.getSelectionModel().getSelectedItem();
            Map<String, Integer> monthsToCyclists = cyclingStatistics.monthlyCyclists(chosenLocation);

            barChart.getData().clear();
            XYChart.Series barChartData = new XYChart.Series();

            monthsToCyclists.keySet().stream().forEach(month -> {
                barChartData.getData().add(new XYChart.Data(month, monthsToCyclists.get(month)));
            });

            barChart.getData().add(barChartData);
        });

        gridPane.add(barChart, 1, 0, 1, 2);

        Scene view = new Scene(gridPane);
        stage.setScene(view);

        stage.show();
    }

    public static void main(String[] args) {
        launch(CyclingStatisticsApplication.class);
    }
}
