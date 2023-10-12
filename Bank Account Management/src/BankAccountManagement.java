import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BankAccountManagement {
    private List<BankCustomer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void listAllCustomers() {
        System.out.println("Enter admin password :");
        String adminPassword = scanner.next();

        if ("admin".equals(adminPassword)) {
            for (BankCustomer customer : customers) {
                customer.listAccounts();
                System.out.println("====================================");
            }
        } else {
            System.out.println("Invalid Password!");
        }
    }

    public BankCustomer authenticateCustomer(int customerId, String password) {
        for (BankCustomer customer : customers) {
            if (customer.getCustomerId() == customerId && customer.verifyPassword(password)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer() {
        System.out.print("Enter name: ");
        String customerName = scanner.next();
        System.out.print("Enter Bank Name: ");
        String bankName = scanner.next();
        System.out.print("Enter a password: ");
        String customerPassword = scanner.next();

        BankCustomer customer = new BankCustomer(customerName, customerPassword, bankName);
        customers.add(customer);
        customer.addAccount();
        customer.listAccounts();
        login();
    }

    public void login() {
        System.out.print("Enter your Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        BankCustomer authenticatedCustomer = authenticateCustomer(customerId, password);

        if (authenticatedCustomer != null) {
            System.out.println("Authentication successful.");
            loggedInMenu(authenticatedCustomer);
        } else {
            System.out.println("Authentication failed. Invalid Customer ID or Password.");
        }
    }

    public void loggedInMenu(BankCustomer customer) {
        while (true) {
            System.out.println("Logged In Menu:");
            System.out.println("1. List Accounts");
            System.out.println("2. Add an account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Logout");

            System.out.print("Please choose an option : ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    customer.listAccounts();
                    break;
                case 2:
                    customer.addAccount();
                    break;
                case 3:
                    performDeposit(customer);
                    break;
                case 4:
                    performWithdraw(customer);
                    break;
                case 5:
                    System.out.println("Logging out. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private void performDeposit(BankCustomer customer) {
        System.out.print("Enter account number to deposit: ");
        int accountNumberToDeposit = scanner.nextInt();
        Account account = customer.getAccount(accountNumberToDeposit);

        if (account != null) {
            System.out.print("Enter the amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
            System.out.println("Deposit of amount " + depositAmount + " successful.");
            account.checkBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    private void performWithdraw(BankCustomer customer) {
        System.out.print("Enter account number to withdraw: ");
        int accountNumberToWithdraw = scanner.nextInt();
        Account account = customer.getAccount(accountNumberToWithdraw);

        if (account != null) {
            System.out.print("Enter the amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);
            System.out.println("Withdraw of amount " + withdrawAmount + " successful.");
            account.checkBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void showMainMenu() {
        System.out.println("Menu:");
        System.out.println("1. Create a new account");
        System.out.println("2. Log in");
        System.out.println("3. See all the customers (admin)");
        System.out.println("4. Exit");
    }

    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                addCustomer();
                break;
            case 2:
                login();
                break;
            case 3:
                listAllCustomers();
                break;
            case 4:
                System.out.println("Exiting the application. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

    public static void main(String[] args) {
        BankAccountManagement accountManagement = new BankAccountManagement();

        System.out.println("Welcome to the Bank Application!");

        while (true) {
            accountManagement.showMainMenu();
            System.out.print("Please choose an option : ");
            int option = scanner.nextInt();
            scanner.nextLine();
            accountManagement.handleMenuChoice(option);
        }
    }
}
