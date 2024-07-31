package Bank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// BankCustomer class to represent a customer
class BankCustomer {
    private String name;
    private int accountNumber;

    public BankCustomer(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "BankCustomer{name='" + name + "', accountNumber=" + accountNumber + '}';
    }
}

// BankAccount class to represent a bank account
class BankAccount {
    private BankCustomer customer;
    private double balance;

    public BankAccount(BankCustomer customer) {
        this.customer = customer;
        this.balance = 0.0;
    }

    public BankCustomer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{customer=" + customer + ", balance=" + balance + '}';
    }
}

// Bank class to manage multiple accounts
class Bank {
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private int nextAccountNumber = 1;

    public BankAccount openAccount(String customerName) {
        BankCustomer customer = new BankCustomer(customerName, nextAccountNumber++);
        BankAccount account = new BankAccount(customer);
        accounts.put(customer.getAccountNumber(), account);
        System.out.println("Account opened for " + customerName + " with account number " + customer.getAccountNumber());
        return account;
    }

    public BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}

// Main class to run the banking system
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Open account\n2. Deposit money\n3. Withdraw money\n4. Check balance\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.next();
                    bank.openAccount(name);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    BankAccount account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = scanner.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println("Balance: " + account.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
