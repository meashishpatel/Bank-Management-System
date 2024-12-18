import java.io.*;
import java.util.*;

public class Bank {
    private static final String FILE_NAME = "bank_data.dat";
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        loadAccounts();
    }

    // Load accounts from file
    private void loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (Map<String, Account>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }

    // Save accounts to file
    private void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Create a new account
    public void createAccount(String name, String accountNumber, int age, double initialBalance) {
        Account newAccount = new Account(name, accountNumber, age, initialBalance);
        accounts.put(accountNumber, newAccount);
        saveAccounts();
        System.out.println("Account created successfully!");
    }

    // Deposit money
    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            saveAccounts();
            System.out.println("Deposited " + amount + " successfully. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money
    public void withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            if (account.withdraw(amount)) {
                saveAccounts();
                System.out.println("Withdrew " + amount + " successfully. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds or minimum balance constraint violated.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // Balance Inquiry
    public void balanceInquiry(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Current balance for account " + accountNumber + ": " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Update customer details
    public void updateAccount(String accountNumber, String newName, int newAge) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setName(newName);
            account.setAge(newAge);
            saveAccounts();
            System.out.println("Account details updated successfully!");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Delete an account
    public void deleteAccount(String accountNumber) {
        if (accounts.remove(accountNumber) != null) {
            saveAccounts();
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Display all accounts (for testing purposes)
    public void displayAccounts() {
        for (Account account : accounts.values()) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Name: " + account.getName());
            System.out.println("Age: " + account.getAge());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("---------------------------");
        }
    }
}
