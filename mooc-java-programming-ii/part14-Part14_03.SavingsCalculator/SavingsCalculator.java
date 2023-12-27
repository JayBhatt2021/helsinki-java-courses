package application;

import java.util.HashMap;

public class SavingsCalculator {
    private Double monthlySavings;
    private Double yearlyInterestRate;
    HashMap<Integer, Double> nextYearsAmountNoRates;
    HashMap<Integer, Double> nextYearsAmountWithRates;

    public SavingsCalculator() {
        monthlySavings = 25.0;
        yearlyInterestRate = 0.0;
        nextYearsAmountNoRates = new HashMap<>();
        nextYearsAmountWithRates = new HashMap<>();
    }

    public void setMonthlySavings(Double monthlySavings) {
        this.monthlySavings = monthlySavings;
    }

    public void setYearlyInterestRate(Double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate / 100;
    }

    public Double getMonthlySavings() {
        return monthlySavings;
    }

    public Double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public HashMap<Integer, Double> getNextYearsAmountNoRates() {
        return nextYearsAmountNoRates;
    }

    public HashMap<Integer, Double> getNextYearsAmountWithRates() {
        return nextYearsAmountWithRates;
    }

    public void calculateYearlyAmountNoRates() {
        nextYearsAmountNoRates.put(0, 0.0);
        for (int years = 1; years <= 30; years++) {
            nextYearsAmountNoRates.put(years, monthlySavings * years * 12);
        }
    }

    public void calculateYearlyAmountWithRates() {
        Double savedInAYear = monthlySavings * 12;
        Double currentAmount = 0.0;       
        nextYearsAmountWithRates.put(0, 0.0);         
        for (int years = 1; years <= 30; years++) {
            currentAmount = (savedInAYear + currentAmount) * (yearlyInterestRate + 1);
            nextYearsAmountWithRates.put(years, currentAmount);
        }
    }
}