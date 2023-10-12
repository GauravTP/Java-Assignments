public class Account {
    public int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Amount couldn't be withdrawn due to insufficient balance!");
        } else {
            this.balance -= amount;
        }
    }

    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber + ", balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
