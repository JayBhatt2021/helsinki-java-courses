import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    private final HashMap<String, HashMap<Integer, Double>> values;

    public PartiesApplication() {
        this.values = this.readVoterFile("partiesdata.tsv");
    }

    private HashMap<String, HashMap<Integer, Double>> readVoterFile(String filename) {
        ArrayList<Integer> yearList = new ArrayList<>();
        HashMap<String, HashMap<Integer, Double>> returnValue = new HashMap<>();

        try (Scanner scanner = new Scanner(Paths.get(filename))) {
            String row = scanner.nextLine();
            String[] rowElements = row.split("\t");

            for (int i = 1; i < rowElements.length; i++) {
                yearList.add(Integer.parseInt(rowElements[i]));
            }

            while (scanner.hasNext()) {
                row = scanner.nextLine();
                rowElements = row.split("\t");
                String partyName = rowElements[0];

                HashMap<Integer, Double> yearPercentMap = new HashMap<>();
                for (int i = 1; i < rowElements.length; i++) {
                    if (!rowElements[i].equals("-")) {
                        int year = yearList.get(i - 1);
                        double percent = Double.parseDouble(rowElements[i]);

                        yearPercentMap.put(year, percent);
                    }
                }

                returnValue.put(partyName, yearPercentMap);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.toString());
        }

        return returnValue;
    }

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        this.values.keySet().stream().forEach(partyName -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(partyName);

            this.values.get(partyName).entrySet().stream().forEach(yearPercentPair -> {
                data.getData().add(new XYChart.Data(yearPercentPair.getKey(), yearPercentPair.getValue()));
            });

            lineChart.getData().add(data);
        });

        Scene view = new Scene(lineChart, 400, 300);
        stage.setScene(view);

        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
}
