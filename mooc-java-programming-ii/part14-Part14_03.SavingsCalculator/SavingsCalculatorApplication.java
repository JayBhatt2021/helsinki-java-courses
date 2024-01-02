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

    @Override
    public void start(Stage window) throws Exception {
        LineChart<Number, Number> graphic = this.createGraphic();
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(graphic);

        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);

        Label monthlySavingsAmountLabel = new Label("25.0");
        monthlySavingsSlider.valueProperty().addListener((unused1, unused2, monthlySavingsValue) -> {
            monthlySavingsAmountLabel.setText(this.roundDouble(monthlySavingsValue.doubleValue()));
        });

        BorderPane monthlySavingsLayout = new BorderPane();
        monthlySavingsLayout.setPadding(new Insets(20, 20, 20, 20));
        monthlySavingsLayout.setLeft(new Label("Monthly savings"));
        monthlySavingsLayout.setCenter(monthlySavingsSlider);
        monthlySavingsLayout.setRight(monthlySavingsAmountLabel);

        monthlySavingsSlider.setOnMouseReleased(unused -> {
            this.generateMonthlySavingsData(monthlySavingsSlider.getValue());

            mainLayout.setCenter(
                    this.updateGraphic(
                            graphic,
                            this.transformMonthlySavingsData(),
                            this.transformAnnualInterestRateData()
                    )
            );
        });

        Slider annualInterestRateSlider = new Slider(0, 10, 0);
        annualInterestRateSlider.setShowTickMarks(true);
        annualInterestRateSlider.setShowTickLabels(true);

        Label annualInterestRateAmountLabel = new Label("0.0");
        annualInterestRateSlider.valueProperty().addListener((unused1, unused2, annualInterestRateValue) -> {
            annualInterestRateAmountLabel.setText(this.roundDouble(annualInterestRateValue.doubleValue()));
        });

        BorderPane annualInterestRateLayout = new BorderPane();
        annualInterestRateLayout.setPadding(new Insets(20, 20, 20, 20));
        annualInterestRateLayout.setLeft(new Label("Yearly interest rate"));
        annualInterestRateLayout.setCenter(annualInterestRateSlider);
        annualInterestRateLayout.setRight(annualInterestRateAmountLabel);

        annualInterestRateSlider.setOnMouseReleased(unused -> {
            this.generateAnnualInterestRateData(
                    monthlySavingsSlider.getValue(),
                    annualInterestRateSlider.getValue()
            );

            mainLayout.setCenter(
                    this.updateGraphic(
                            graphic,
                            this.transformMonthlySavingsData(),
                            this.transformAnnualInterestRateData()
                    )
            );
        });

        VBox vBox = new VBox();
        vBox.getChildren().add(monthlySavingsLayout);
        vBox.getChildren().add(annualInterestRateLayout);

        mainLayout.setTop(vBox);

        window.setTitle("Savings calculator application");
        window.setScene(new Scene(mainLayout, 800, 600));
        window.show();
    }

    private LineChart<Number, Number> createGraphic() {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        xAxis.setLabel("Years");

        NumberAxis yAxis = new NumberAxis(0, 10000, 2500);
        yAxis.setLabel("Savings");

        LineChart<Number, Number> graphic = new LineChart<>(xAxis, yAxis);
        graphic.setTitle("Savings Calculator");

        this.generateMonthlySavingsData(25.0);
        graphic.getData().add(this.transformMonthlySavingsData());

        this.generateAnnualInterestRateData(25.0, 0.0);
        graphic.getData().add(this.transformAnnualInterestRateData());

        return graphic;
    }

    private LineChart<Number, Number> updateGraphic(
            LineChart<Number, Number> graphic,
            XYChart.Series monthlySavingsData,
            XYChart.Series annualInterestRateData) {

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        xAxis.setLabel("Years");

        Double yAxisMaxValue = this.calculatorLogic.getNextYearsAmountWithRates()
                .values()
                .stream()
                .max(Comparator.comparing(Double::doubleValue))
                .orElse(0.0);
        NumberAxis yAxis = new NumberAxis(0, yAxisMaxValue, yAxisMaxValue / 10);
        yAxis.setLabel("Savings");

        graphic = new LineChart<>(xAxis, yAxis);
        graphic.setTitle("Savings Calculator");

        graphic.getData().clear();
        graphic.getData().add(monthlySavingsData);
        graphic.getData().add(annualInterestRateData);

        return graphic;
    }

    private void generateMonthlySavingsData(Double monthlySavings) {
        this.calculatorLogic.setMonthlySavings(monthlySavings);
        this.calculatorLogic.calculateYearlyAmountNoRates();
    }

    private XYChart.Series transformMonthlySavingsData() {
        XYChart.Series monthlySavingsChart = new XYChart.Series();
        monthlySavingsChart.setName("Monthly Savings");

        this.calculatorLogic.getNextYearsAmountNoRates().entrySet().forEach(entry -> {
            monthlySavingsChart.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        });

        return monthlySavingsChart;
    }

    private void generateAnnualInterestRateData(Double monthlySavings, Double annualInterestRate) {
        if (monthlySavings != this.calculatorLogic.getMonthlySavings()) {
            this.generateMonthlySavingsData(monthlySavings);
        }

        this.calculatorLogic.setYearlyInterestRate(annualInterestRate);
        this.calculatorLogic.calculateYearlyAmountWithRates();
    }

    private XYChart.Series transformAnnualInterestRateData() {
        this.calculatorLogic.calculateYearlyAmountWithRates();

        XYChart.Series yearlyInterestRateChart = new XYChart.Series();
        yearlyInterestRateChart.setName("Savings with interest rate");

        this.calculatorLogic.getNextYearsAmountWithRates().entrySet().forEach(entry -> {
            yearlyInterestRateChart.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        });

        return yearlyInterestRateChart;
    }

    private String roundDouble(Double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        return df.format(value.doubleValue());
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
}
