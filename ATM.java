import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    // To initialize ATM with a default balance, PIN, and empty transaction history
    public ATM(double initialBalance, int initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
    }

    // To check balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

    // To deposit cash
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You have successfully deposited $" + amount);
            transactionHistory.add("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // To withdraw cash
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("You have successfully withdrawn $" + amount);
            transactionHistory.add("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // To change PIN
    public void changePin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("Your PIN has been successfully changed.");
            transactionHistory.add("PIN changed.");
        } else {
            System.out.println("Incorrect old PIN.");
        }
    }

    // To display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // To validate PIN before performing sensitive actions
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000.0, 1234);  // Initial balance: $1000, Initial PIN: 1234

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (atm.validatePin(enteredPin)) {
            int choice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Cash");
                System.out.println("3. Withdraw Cash");
                System.out.println("4. Change PIN");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.print("Enter old PIN: ");
                        int oldPin = scanner.nextInt();
                        System.out.print("Enter new PIN: ");
                        int newPin = scanner.nextInt();
                        atm.changePin(oldPin, newPin);
                        break;
                    case 5:
                        atm.displayTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } while (choice != 6);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        scanner.close();
    }
}
