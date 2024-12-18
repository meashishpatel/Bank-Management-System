# Bank Management System

This is a simple **Bank Management System** built in **Java** that allows customers to create accounts, perform transactions (deposit and withdrawal), check their balance, and manage account details. The system stores account information persistently using file handling, allowing the data to be retrieved across different sessions.

## Features

### 1. Account Creation

- Register a new user by providing their **Name**, **Account Number**, **Age**, and **Initial Balance**.

### 2. Account Operations

- **Deposit Money**: Add funds to a customer's account.
- **Withdraw Money**: Deduct funds from a customer's account (ensuring the balance doesn't fall below ₹1000).
- **Balance Inquiry**: Display the current balance of a customer's account.

### 3. Account Management

- **Update Account**: Modify the customer's details such as **Name** or **Age**.
- **Delete Account**: Remove an account when it's no longer needed.

### 4. Data Persistence

- **File Handling**: The account data is stored and retrieved from a file (`bank_data.dat`), ensuring that the information is saved even after the application is closed and reopened.

## How It Works

### 1. **Account Class**

The `Account` class represents the customer account, which includes the account holder's details such as **Name**, **Account Number**, **Age**, and **Balance**. It has methods for:

- Depositing money.
- Withdrawing money (with a check to ensure the balance doesn't fall below ₹1000).
- Updating details such as **Name** and **Age**.

### 2. **Bank Class**

The `Bank` class manages the collection of accounts using a `HashMap`. It provides methods for:

- **Creating new accounts**.
- **Depositing and withdrawing money**.
- **Displaying the account balance**.
- **Saving and loading account data** using file handling (Serialization).

### 3. **BankManagementSystem Class**

This is the main driver class that provides a console-based menu for the user to interact with the system. The user can:

- Create new accounts.
- Perform transactions like deposit and withdrawal.
- Check balances, update account information, or delete accounts.

### 4. **File Handling**

Account information is saved to a file (`bank_data.dat`) in a serialized format, and is loaded whenever the program starts. This allows the system to persist account data across sessions.

---

## Project Setup

### Prerequisites

- **Java** (JDK 8 or later)

### Running the Program

1. **Clone or Download the Repository**: Download or clone the project folder to your local machine.
2. **Compile the Program**:
   - Open a terminal or command prompt in the project directory.
   - Run the following command to compile the Java files:
     ```
     javac BankManagementSystem.java
     ```
3. **Run the Program**:
   - After compilation, run the program using the following command:
     ```
     java BankManagementSystem
     ```
   - The program will display a menu where you can perform operations such as creating accounts, depositing or withdrawing money, etc.

### Example Usage

When you run the program, you will see a menu like this:

Bank Management System

- Create Account
- Deposit Money
- Withdraw Money
- Balance Inquiry
- Update Account
- Delete Account
- Display All Accounts
- Exit Enter your choice:

### Example Commands

1. **Create Account**:
   - Choose option 1, then enter the details (Name, Account Number, Age, Initial Balance).
2. **Deposit Money**:
   - Choose option 2, then enter the **Account Number** and **Amount** to deposit.
3. **Withdraw Money**:

   - Choose option 3, then enter the **Account Number** and **Amount** to withdraw (ensure that the balance stays above ₹1000).

4. **Balance Inquiry**:

   - Choose option 4, then enter the **Account Number** to view the current balance.

5. **Update Account**:

   - Choose option 5, then enter the **Account Number**, **New Name**, and **New Age** to update the account details.

6. **Delete Account**:
   - Choose option 6, then enter the **Account Number** to delete the account.

---

---

## Notes

- **Persistence**: All customer data is saved to a file (`bank_data.dat`) using **serialization**, so the data persists even after the program is closed and reopened.
- **Minimum Balance**: The system ensures that accounts do not drop below ₹1000 when withdrawing money.
- **Error Handling**: Basic error handling is implemented to prevent invalid operations such as withdrawing more than the available balance or deleting a non-existent account.
