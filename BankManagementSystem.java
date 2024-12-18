import java.util.Scanner;

public class BankManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    balanceInquiry();
                    break;
                case 5:
                    updateAccount();
                    break;
                case 6:
                    deleteAccount();
                    break;
                case 7:
                    bank.displayAccounts();
                    break;
                case 8:
                    System.out.println("Exiting... Thank you for using the bank system!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n---- Bank Management System ----");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Balance Inquiry");
        System.out.println("5. Update Account");
        System.out.println("6. Delete Account");
        System.out.println("7. Display All Accounts");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createAccount() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        bank.createAccount(name, accountNumber, age, initialBalance);
    }

    private static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Deposit Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        bank.deposit(accountNumber, amount);
    }

    private static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Withdrawal Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        bank.withdraw(accountNumber, amount);
    }

    private static void balanceInquiry() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        bank.balanceInquiry(accountNumber);
    }

    private static void updateAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter New Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        bank.updateAccount(accountNumber, newName, newAge);
    }

    private static void deleteAccount() {
        System.out.print("Enter Account Number to Delete: ");
        String accountNumber = scanner.nextLine();
        bank.deleteAccount(accountNumber);
    }
}
