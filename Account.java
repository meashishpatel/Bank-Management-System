import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private String accountNumber;
    private int age;
    private double balance;

    // Constructor
    public Account(String name, String accountNumber, int age, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.age = age;
        this.balance = balance;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && balance - amount >= 1000) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
