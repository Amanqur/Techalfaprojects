import java.util.Scanner;

public class BankingApplication {
    private static double balance = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nWelcome to Simple Banking Application");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our Banking Application!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 4);
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Your new balance is: " + balance);
        } else {
            System.out.println("Invalid amount! Deposit failed.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Your new balance is: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance! Withdrawal failed.");
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }
}