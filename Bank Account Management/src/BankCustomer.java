import java.util.HashMap;

public class BankCustomer {
    private static int nextCustomerId = 1;
    private int customerId;
    private String name;
    private String password;
    private String BankName;
    private HashMap<Integer, Account> accounts = new HashMap<>();

    public BankCustomer(String name, String password, String BankName) {
        this.customerId = nextCustomerId++;
        this.name = name;
        this.password = password;
        this.BankName = BankName;
    }

    public boolean verifyPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void addAccount() {
        int accountNumber = getNextAccountNumber();
        Account account = new Account(accountNumber, 0);
        accounts.put(accountNumber, account);
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getNextAccountNumber() {
        int highest = 0;
        for (HashMap.Entry<Integer, Account> set : accounts.entrySet()) {
            if (set.getKey() > highest) {
                highest = set.getKey();
            }
        }
        return highest + 1;
    }

    public void listAccounts() {
        System.out.println("--------------------");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + name);
        System.out.println("Bank Name: " + BankName);
        System.out.println("Accounts:");

        for (HashMap.Entry<Integer, Account> entry : accounts.entrySet()) {
            int accountNumber = entry.getKey();
            Account account = entry.getValue();

            System.out.println("\t" + "Account Number: " + accountNumber);
            System.out.println("\t" + "Balance: " + account.getBalance());
            System.out.println("--------------------");
        }
    }
}
