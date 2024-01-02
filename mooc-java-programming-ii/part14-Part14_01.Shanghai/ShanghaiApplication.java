import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {
    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(2007, 2017, 2);
        xAxis.setLabel("Year");

        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series uohData = new XYChart.Series();
        uohData.setName("testing");
        uohData.getData().add(new XYChart.Data(2007, 73));
        uohData.getData().add(new XYChart.Data(2008, 68));
        uohData.getData().add(new XYChart.Data(2009, 72));
        uohData.getData().add(new XYChart.Data(2010, 72));
        uohData.getData().add(new XYChart.Data(2011, 74));
        uohData.getData().add(new XYChart.Data(2012, 73));
        uohData.getData().add(new XYChart.Data(2013, 76));
        uohData.getData().add(new XYChart.Data(2014, 73));
        uohData.getData().add(new XYChart.Data(2015, 67));
        uohData.getData().add(new XYChart.Data(2016, 56));
        uohData.getData().add(new XYChart.Data(2017, 56));

        lineChart.getData().add(uohData);

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);

        stage.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }
}
