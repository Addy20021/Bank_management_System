
class Account {
    private int accountNumber;
    private double balance;


    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }


    public double calculateInterest() {
        return 0.0;
    }


    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance       : $" + balance);
    }
}


class SavingsAccount extends Account {
    private double interestRate;


    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }


    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    // Display interest info
    public void displayInterest() {
        System.out.println("Savings Interest: $" + calculateInterest());
    }
}


class CheckingAccount extends Account {
    private double monthlyFee;


    public CheckingAccount(int accountNumber, double balance, double monthlyFee) {
        super(accountNumber, balance);
        this.monthlyFee = monthlyFee;
    }

    
    @Override
    public double calculateInterest() {
        return 0.0;  
    }


    public void displayMonthlyFee() {
        System.out.println("Monthly Fee: $" + monthlyFee);
    }
}


public class MainBank {
    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount(1001, 5000.0, 0.04);  
        System.out.println("--- Savings Account ---");
        savings.displayAccountInfo();
        savings.deposit(1000);
        savings.withdraw(500);
        savings.displayInterest();


        CheckingAccount checking = new CheckingAccount(2001, 3000.0, 12.0); 
        System.out.println("\n--- Checking Account ---");
        checking.displayAccountInfo();
        checking.deposit(500);
        checking.withdraw(1000);
        checking.displayMonthlyFee();
        System.out.println("Checking Interest: $" + checking.calculateInterest());


        System.out.println("\n--- Interest Calculation Demonstration ---");
        System.out.println("Savings Account Interest: $" + savings.calculateInterest());
        System.out.println("Checking Account Interest: $" + checking.calculateInterest());
    }
}
