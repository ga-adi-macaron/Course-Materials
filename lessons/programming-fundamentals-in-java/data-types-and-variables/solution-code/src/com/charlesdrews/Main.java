package com.charlesdrews;

/**
 * This was created to be independent practice for working with variables of different data types.
 *
 * SOURCES:
 * http://www.mybudget360.com/cost-of-living-2014-inflation-1950-vs-2014-data-housing-cars-college/
 * http://oir.yale.edu/1701-1976-yale-book-numbers
 * http://www.yale.edu/tuba/finaid/finaid-information/1516/1516EA_FYYE.pdf
 * http://www.forbes.com/sites/erincarlyle/2014/01/30/manhattan-real-estate-ten-year-review-neighborhoods-where-prices-have-gone-up-the-most/
 * https://www.mainstreet.com/article/americans-personal-debt-skyrockets
 * http://www.nerdwallet.com/blog/credit-card-data/average-credit-card-debt-household/
 **/
public class Main {

    public static void main(String[] args) {

        // TODO: Complete the following variable declarations.

        int oldYear = 1950;
        int nowYear = 2016;

        double averageFamilyIncome1950 = 3_300;
        double medianHomePrice1950 = 7_354;
        double tuitionYale1950 = 600;
        double roomAndBoardYale1950 = 456;
        double otherExpensesYale1950 = 376;

        double averageFamilyIncome2015 = 51_017;
        double medianHomePrice2015 = 188_900;
        double medianHomePriceManhattan2013 = 855_000;
        double tuitionYale2016 = 55_800;
        double roomAndBoardYale2016 = 17_000;
        double otherExpensesYale2016 = 5_520;

        String intro = "To understand how purchasing power has changed in the past 65 years, it is useful to compare the family income to the cost of goods and services, such as housing and education.";

        // TODO: Find and fix a mistake in the following.
        if (intro.equals("A long time ago in a galaxy far, far away")) {
            System.out.println("May the force be with you.");
        }
        else {
            System.out.println(intro);
        }

        // TODO: Use a print statement to add a newline or <br>.
        System.out.println("\n");

        // TODO: Complete the following basic mathematical calculations.
        // Divide median home price by annual income and print each result to the command line.
        // Make 3 variables: homeRatio1950, homeRatio2015, homeRatioNYC2015
        double homeRatio1950 = medianHomePrice1950 / averageFamilyIncome1950;
        System.out.println("homeRatio1950 = " + homeRatio1950);
        double homeRatio2015 = medianHomePrice2015 / averageFamilyIncome2015;
        System.out.println("homeRatio2015 = " + homeRatio2015);
        double homeRatioNYC2015 = medianHomePriceManhattan2013 / averageFamilyIncome2015;
        System.out.println("homeRatioNYC2015 = " + homeRatioNYC2015);

        // Find the total cost of university education for 1950 and for 2015 and print result to the command line.
        // Then divide university cost by annual income for both: educationRatio1950, & educationRation2015. Print the results to the command line.
        double privateUniversityCost1950 = tuitionYale1950 + roomAndBoardYale1950 + otherExpensesYale1950;
        double educationRatio1950 = privateUniversityCost1950 / averageFamilyIncome1950;
        System.out.println("educationRatio1950 = " + educationRatio1950);
        double privateUniversityCost2016 = tuitionYale2016 + roomAndBoardYale2016 + otherExpensesYale2016;
        double educationRation2016 = privateUniversityCost2016 / averageFamilyIncome2015;
        System.out.println("educationRation2016 = " + educationRation2016);

        // TODO: Convert the following String into a number.
        String averageDebt1950String = "2000";
        double averageDebt1950 = Double.parseDouble(averageDebt1950String);

        // TODO: Complete the following variable declarations, and replace the /*something*/'s in the String with the proper variables.
        double creditCardDebt2010 = 15_355;
        double averageTotalDebt2010 = 129_579;
        String debt = "Debt is an unwelcome guest at the table in many American households. Back in the late 1940s and early 1950s, the average American consumer had less than $"+averageDebt1950+" in total personal debt. Today the average U.S. household with debt carries $"+creditCardDebt2010+" in credit card debt and $"+averageTotalDebt2010+" in total debt.";

        // TODO: Using one line of code, determine if the following string contains the word "table". Print the result to the command line.
        boolean hasTable = debt.contains("table");
        System.out.println("hasTable = " + hasTable);

        // TODO: How has the ratio of debt to income changed in the past 60 years?
        double debtRatio1950 = averageDebt1950 / averageFamilyIncome1950;
        System.out.println("debtRation1950 = " + debtRatio1950);
        double debtRatio2010 = averageTotalDebt2010 / averageFamilyIncome2015;
        System.out.println("debtRatio2010 = " + debtRatio2010);

        // EXTRA: Round the answer to two decimal places.
        double debtRatio1950twoDecimals = Math.round(debtRatio1950 * 100.0) / 100.0;
        System.out.println("debtRatio1950twoDecimals = " + debtRatio1950twoDecimals);
        double debtRatio2010twoDecimals = Math.round(debtRatio2010 * 100.0) / 100.0;
        System.out.println("debtRatio2010twoDecimals = " + debtRatio2010twoDecimals);
    }
}
