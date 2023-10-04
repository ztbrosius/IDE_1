// set up header
/*
IDE Project 1
CSC 222
Zachary Brosius

A simple calculator program to compare some costs associated with ev vs gas vehicles
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public static void main(String[] args) {
        // create variables to hold input data for gas car
        String gasCarName = new String();
        double gasMonthlyPayment;
        double gasPerGallonCost;
        double gasAvgMilesRating;
        double avgWeeklyMiles;
        double gasMonthlyCosts;
        double gasYearlyCosts;

        // create variable to hold input data for electric car
        String electricCarName = new String();
        double electricMonthlyPayment;
        double electricCostPerMile;
        double electricMonthlyCosts;
        double electricYearlyCosts;

        // create a constant variable to hold weeks in a month
        final double WEEKS_IN_MONTH = 4.3;
        final double MONTHS_IN_YEAR = 12;

        // variable used in the comparison output
        double savingsCostMonth;
        double savingsCostYear;

        System.out.println("******************");
        System.out.println("Let's begin by getting details for the gas car.");

        // create Scanner object to get input from the user
        Scanner input = new Scanner(System.in);

        // begin by getting required input from user:
        System.out.println("Enter the name for your gas car (Example Toyota Camry): ");
        gasCarName = input.nextLine();

//      get the monthly finance payment for the gas car
        System.out.println("Enter the monthly finance payment for your gas car: ");
        gasMonthlyPayment = input.nextDouble();

//      get the cost of gas per gallon
        System.out.println("Enter the cost of gas per gallon: ");
        gasPerGallonCost = input.nextDouble();

//      get the average miles per gallon of gas the car is rated at
        System.out.println("Enter the average miles per gallon of gas the car is rated at: ");
        gasAvgMilesRating = input.nextDouble();
        System.out.println("******************");



        // get the electric car name
        // need to flush the buffer
        input.nextLine();
        System.out.println("Enter the name for your electric car (Example Tesla X): ");
        electricCarName = input.nextLine();

//      get the monthly finance payment for the electric car
        System.out.println("Enter the monthly finance payment for your electric car: ");
        electricMonthlyPayment = input.nextDouble();

//      get the cost of electricity per mile
        System.out.println("Enter the cost of electricity per mile: ");
        electricCostPerMile = input.nextDouble();




        // ask the user about the weekly miles they drive
        System.out.println("How many miles on average do you drive each week?");
        avgWeeklyMiles = input.nextDouble();
        System.out.println("******************");

        double weeklyGasCosts = calculateWeeklyGasConsumptionCost(avgWeeklyMiles, gasAvgMilesRating, gasPerGallonCost);
//        System.out.println("Weekly gas consumption cost: $"+ DECIMAL_FORMAT.format(weeklyGasCosts));

        double weeklyElectricCosts = calculateWeeklyElectricConsumptionCost(avgWeeklyMiles, electricCostPerMile);
//        System.out.println("Weekly electric consumption cost: $"+ DECIMAL_FORMAT.format(weeklyElectricCosts));

//        // test if we can calculate monthly cost for each vehicle
//        System.out.println("Monthly Gas consumption cost: $"+ DECIMAL_FORMAT.format(weeklyGasCosts * WEEKS_IN_MONTH));
//        System.out.println("Monthly electric consumption cost: $"+ DECIMAL_FORMAT.format(weeklyElectricCosts * WEEKS_IN_MONTH));

        // calculate the monthly costs (weekly costs and finance payment) and hold in a variable
        gasMonthlyCosts = (weeklyGasCosts * WEEKS_IN_MONTH) + gasMonthlyPayment;
        electricMonthlyCosts = (weeklyElectricCosts * WEEKS_IN_MONTH) + electricMonthlyPayment;

        // calculate the yearly costs and hold it in a variable
        gasYearlyCosts = (gasMonthlyCosts * MONTHS_IN_YEAR);
        electricYearlyCosts = (electricMonthlyCosts * MONTHS_IN_YEAR);


        // gas output
        System.out.println("Results based on the data you entered: ");
        System.out.println("GAS CAR DATA: ");
        System.out.println("Car Name: " + gasCarName);
        System.out.println("Average Cost/Week for gas: $" + DECIMAL_FORMAT.format(weeklyGasCosts));
        System.out.println("Average Cost/Month for payment and gas: $" + DECIMAL_FORMAT.format(gasMonthlyCosts) + " (based on average of 4.3 weeks per month.)");
        System.out.println("Average Cost/Year for payment and gas: $" + DECIMAL_FORMAT.format(gasYearlyCosts) + " (based on monthly costs * 12)");
        System.out.println("******************");

        // electric output
        System.out.println("ELECTRIC CAR DATA: ");
        System.out.println("Car Name: " + electricCarName);
        System.out.println("Average Cost/Week for electric: $" + DECIMAL_FORMAT.format(weeklyElectricCosts));
        System.out.println("Average Cost/Month for payment and electric: $" + DECIMAL_FORMAT.format(electricMonthlyCosts) + " (based on average of 4.3 weeks per month.)");
        System.out.println("Average Cost/Year for payment and electric: $" + DECIMAL_FORMAT.format(electricYearlyCosts) + " (based on monthly costs * 12)");
        System.out.println("******************");

        // rest of the comparison output
        System.out.println("COMPARISON RESULTS: ");
        System.out.println("Based on comparison, if you bought the electric car, you would save or lose the following money: ");
        System.out.println("Negative means savings, positive means loss/you are paying more.");

        savingsCostMonth = electricMonthlyCosts - gasMonthlyCosts;
        savingsCostYear = savingsCostMonth * MONTHS_IN_YEAR;

        System.out.println("Savings/Costs per month: $" + DECIMAL_FORMAT.format(savingsCostMonth) + " (electric monthly car costs - gas monthly car cost)");
        System.out.println("Savings/Costs per year: $" + DECIMAL_FORMAT.format(savingsCostYear) + " (electric yearly car costs - gas yearly car cost)");
        System.out.println("******************");



    } // ends main method/driver


    // begin coding methods

    // calculate the weekly gas consumption costs
    public static double calculateWeeklyGasConsumptionCost(double weeklyMiles, double avgMilesRating, double gasGallonCost){
        //weekly gallons = weekly miles / avg miles a gallon
        double weeklyGallons = weeklyMiles / avgMilesRating;
        //weekly gas cost = weekly gallons * gas gallon cost
        double weeklyGasCost = weeklyGallons * gasGallonCost;

        return weeklyGasCost;
    }// ends calculateWeeklyGasConsumptionCost

    // calculate the weekly electricity consumption costs
    public static double calculateWeeklyElectricConsumptionCost(double weeklyMiles, double electricMileCosts) {
        //weekly electric cost = weekly gallons * electric mile cost
        double weeklyElectricCosts = weeklyMiles * electricMileCosts;

        return weeklyElectricCosts;
    }

} // ends main class


