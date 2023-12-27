package application;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    private final SavingsCalculator calculatorLogic;

    public SavingsCalculatorApplication() {
        this.calculatorLogic = new SavingsCalculator();
    }

    private String roundDouble(Double valueToRound) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(valueToRound.doubleValue());
    }

    private void generateDataMonthlySavings(Double monthlySavings) {
        calculatorLogic.setMonthlySavings(monthlySavings);
        calculatorLogic.calculateYearlyAmountNoRates();
    }

    private void generateDataAnualInterestRate(Double monthlySavings, Double anualInterestRate) {
        if (calculatorLogic.getMonthlySavings() != monthlySavings) {
            calculatorLogic.setMonthlySavings(monthlySavings);
            calculatorLogic.calculateYearlyAmountNoRates();
        }
        calculatorLogic.setYearlyInterestRate(anualInterestRate);
        calculatorLogic.calculateYearlyAmountWithRates();
    }

    private XYChart.Series transformDataIntoGraphicDataMonthlySavings() {
        XYChart.Series dataMonthlySavings = new XYChart.Series();
        dataMonthlySavings.setName("Monthly Savings");
        calculatorLogic.getNextYearsAmountNoRates().entrySet().forEach(entry -> dataMonthlySavings.getData().add(new XYChart.Data(entry.getKey(), entry.getValue())));
        return dataMonthlySavings;
    }

    private XYChart.Series transformDataIntoGraphicDataAnualInterestRate() {
        calculatorLogic.calculateYearlyAmountWithRates();
        XYChart.Series dataYearlyInterestRate = new XYChart.Series();
        dataYearlyInterestRate.setName("Savings with interest rate");
        calculatorLogic.getNextYearsAmountWithRates().entrySet().forEach(entry -> dataYearlyInterestRate.getData().add(new XYChart.Data(entry.getKey(), entry.getValue())));
        return dataYearlyInterestRate;
    }

    private LineChart<Number, Number> createGraphic() {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 10000, 2500);
        xAxis.setLabel("Years");
        yAxis.setLabel("Savings");
        LineChart<Number, Number> graphic = new LineChart<>(xAxis, yAxis);
        graphic.setTitle("Savings counter");
        generateDataMonthlySavings(25.0);
        generateDataAnualInterestRate(25.0, 0.0);
        graphic.getData().add(transformDataIntoGraphicDataMonthlySavings());
        graphic.getData().add(transformDataIntoGraphicDataAnualInterestRate());

        return graphic;
    }

    private LineChart<Number, Number> updateGraphic(LineChart<Number, Number> graphic, XYChart.Series montlySavings, XYChart.Series anualInterestRate) {
        Double maxValueForTheYAxis = calculatorLogic.getNextYearsAmountWithRates().values().stream().max(Comparator.comparing(Double::doubleValue)).orElse(0.0);
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, maxValueForTheYAxis, maxValueForTheYAxis / 10);
        xAxis.setLabel("Years");
        yAxis.setLabel("Savings");

        graphic = new LineChart<>(xAxis, yAxis);
        graphic.setTitle("Savings counter");

        graphic.getData().clear();
        graphic.getData().add(montlySavings);
        graphic.getData().add(anualInterestRate);
        return graphic;
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        LineChart<Number, Number> graphic = createGraphic();
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(graphic);

        VBox dragSliders = new VBox();

        BorderPane monthlySavingsLayout = new BorderPane();
        monthlySavingsLayout.setPadding(new Insets(20, 20, 20, 20));
        Label monthlySavingAmountDisplayLabel = new Label("25.0");
        Slider monthlySavingSlider = new Slider(25, 250, 25);
        monthlySavingSlider.setShowTickLabels(true);
        monthlySavingSlider.setShowTickMarks(true);
        monthlySavingsLayout.setLeft(new Label("Monthly savings"));
        monthlySavingsLayout.setCenter(monthlySavingSlider);
        monthlySavingsLayout.setRight(monthlySavingAmountDisplayLabel);
        monthlySavingSlider.valueProperty().addListener((changed, oldValue, newValue) -> monthlySavingAmountDisplayLabel.setText(roundDouble(newValue.doubleValue())));
        monthlySavingSlider.setOnMouseReleased(dragOver -> {
            generateDataMonthlySavings(monthlySavingSlider.getValue());
            mainLayout.setCenter(updateGraphic(graphic, transformDataIntoGraphicDataMonthlySavings(), transformDataIntoGraphicDataAnualInterestRate()));
        });

        BorderPane anualInterestRateLayout = new BorderPane();
        anualInterestRateLayout.setPadding(new Insets(20, 20, 20, 20));
        Label anualInterestRateAmountDisplayLabel = new Label("0.0");
        Slider anualInterestRateSlider = new Slider(0, 10, 0);
        anualInterestRateSlider.setShowTickMarks(true);
        anualInterestRateSlider.setShowTickLabels(true);
        anualInterestRateLayout.setLeft(new Label("Yearly interest rate"));
        anualInterestRateLayout.setCenter(anualInterestRateSlider);
        anualInterestRateLayout.setRight(anualInterestRateAmountDisplayLabel);
        anualInterestRateSlider.valueProperty().addListener((changed, oldValue, newValue) -> anualInterestRateAmountDisplayLabel.setText(roundDouble(newValue.doubleValue())));
        anualInterestRateSlider.setOnMouseReleased(dragOver -> {
            generateDataAnualInterestRate(monthlySavingSlider.getValue(), anualInterestRateSlider.getValue());
            mainLayout.setCenter(updateGraphic(graphic, transformDataIntoGraphicDataMonthlySavings(), transformDataIntoGraphicDataAnualInterestRate()));
        });

        dragSliders.getChildren().add(monthlySavingsLayout);
        dragSliders.getChildren().add(anualInterestRateLayout);

        mainLayout.setTop(dragSliders);

        window.setTitle("Savings calculator application");
        window.setScene(new Scene(mainLayout, 800, 600));
        window.show();
    }
}