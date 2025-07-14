import java.util.Scanner;

public class LoanPaymentCalculator {

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Welcome to the Loan Payment Calculator!");

        // Get inputs from user
        double loanAmount = getPositiveDoubleInput("Enter the loan amount: ");
        double annualInterestRate = getPositiveDoubleInput("Enter the annual interest rate (in %): ");
        int loanTermYears = getPositiveIntInput("Enter the loan term (in years): ");

        // Calculate monthly payment
        double monthlyPayment = calculateMonthlyPayment(loanAmount, annualInterestRate, loanTermYears);

        // Output the result
        System.out.printf("Your monthly payment is: $%.2f\n", monthlyPayment);
    }

    private double getPositiveDoubleInput(String prompt) {
        double value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return value;
    }

    private int getPositiveIntInput(String prompt) {
        int value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
        return value;
    }

    private double calculateMonthlyPayment(double loanAmount, double annualInterestRate, int loanTermYears) {
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int numberOfPayments = loanTermYears * 12;
        return (loanAmount * monthlyInterestRate) /
               (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }
}
