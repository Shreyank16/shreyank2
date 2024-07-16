import java.util.*;

public class shreyank2 {
    private double balance = 0;

    public shreyank2(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: $" + amount + ". Your new balance is: $" + this.balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount > this.balance) {
                System.out.println("Insufficient funds");
            } else {
                this.balance -= amount;
                System.out.println("Withdrawn: $" + amount + ". Your new balance is: $" + this.balance);
            }
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }

    public boolean exit() {
        System.out.println("Exiting the ATM. Thank you!");
        return false;
    }

    public static void main(String[] args) {
        shreyank2 atm = new shreyank2(0);
        Scanner s=new Scanner(System.in);

        while (true) {
            System.out.println("===== Welcome to ATM =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            String choice = s.nextLine();

            if ("1".equals(choice)) {
                System.out.println("Your balance is: $" + atm.getBalance());
            } else if ("2".equals(choice)) {
                System.out.print("Enter amount to deposit: $");
                double amount = parseDoubleInput(s.nextLine());
                atm.deposit(amount);
            } else if ("3".equals(choice)) {
                System.out.print("Enter amount to withdraw: $");
                double amount = parseDoubleInput(s.nextLine());
                atm.withdraw(amount);
            } else if ("4".equals(choice)) {
                if (!atm.exit()) {
                    break;
                }
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        s.close();
    }

    private static double parseDoubleInput(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
            return 0;
 }
}
}