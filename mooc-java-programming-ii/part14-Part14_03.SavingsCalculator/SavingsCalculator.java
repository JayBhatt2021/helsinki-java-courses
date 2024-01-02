import java.util.HashMap;

public class SavingsCalculator {
    private Double monthlySavings;
    private Double yearlyInterestRate;
    HashMap<Integer, Double> nextYearsAmountNoRates;
    HashMap<Integer, Double> nextYearsAmountWithRates;

    public SavingsCalculator() {
        this.monthlySavings = 25.0;
        this.yearlyInterestRate = 0.0;
        this.nextYearsAmountNoRates = new HashMap<>();
        this.nextYearsAmountWithRates = new HashMap<>();
    }

    public Double getMonthlySavings() {
        return this.monthlySavings;
    }

    public void setMonthlySavings(Double monthlySavings) {
        this.monthlySavings = monthlySavings;
    }

    public Double getYearlyInterestRate() {
        return this.yearlyInterestRate;
    }

    public void setYearlyInterestRate(Double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate / 100;
    }

    public HashMap<Integer, Double> getNextYearsAmountNoRates() {
        return this.nextYearsAmountNoRates;
    }

    public void calculateYearlyAmountNoRates() {
        this.nextYearsAmountNoRates.put(0, 0.0);

        for (int years = 1; years <= 30; years++) {
            this.nextYearsAmountNoRates.put(years, this.monthlySavings * 12 * years);
        }
    }

    public HashMap<Integer, Double> getNextYearsAmountWithRates() {
        return this.nextYearsAmountWithRates;
    }

    public void calculateYearlyAmountWithRates() {
        Double yearlySavings = this.monthlySavings * 12;
        Double currentAmount = 0.0;

        this.nextYearsAmountWithRates.put(0, 0.0);

        for (int years = 1; years <= 30; years++) {
            currentAmount = (yearlySavings + currentAmount) * (this.yearlyInterestRate + 1);
            this.nextYearsAmountWithRates.put(years, currentAmount);
        }
    }
}
