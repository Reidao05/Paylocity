package utils;

public class EmployeeBenefitsCalculator {

    private static final double YEARLY_SALARY = 52000;
    private static final double GROSS_PAY_PER_PERIOD = 2000;
    private static final double BASE_BENEFITS_COST = 1000;
    private static final double DEPENDENT_COST_PER_YEAR = 500;
    private static final int PAY_PERIODS_PER_YEAR = 26;

    public static double calculateBenefitsCost(int numberOfDependents){
        double totalCostOfBenefits = BASE_BENEFITS_COST + (DEPENDENT_COST_PER_YEAR * numberOfDependents);
        return totalCostOfBenefits / PAY_PERIODS_PER_YEAR;
    }
    public static double calculateNetPay(int numberOfDependents){
        double yearlyBenefitsCost = calculateBenefitsCost(numberOfDependents);
        double benefitsCostPerPeriod = yearlyBenefitsCost / PAY_PERIODS_PER_YEAR;
        return GROSS_PAY_PER_PERIOD - benefitsCostPerPeriod;
    }
    public static boolean validateBenefitsAndNetPay(int numberOfDependents, double expectedBenefits, double expectedNetPay) {
        double calculatedBenefits = calculateBenefitsCost(numberOfDependents);
        double calculatedNetPay = calculateNetPay(numberOfDependents);
        return (calculatedBenefits == expectedBenefits) && (calculatedNetPay == expectedNetPay);
    }
}
