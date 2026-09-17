# Banking Management System

## 1. Project Description

Banking Management System is a simple command-line Java application developed to perform basic banking operations.

The application allows users to create bank accounts, deposit money, withdraw money, transfer money between accounts, check account balances, view account details, and view transaction history.

This project is developed as an educational Java project to demonstrate basic Object-Oriented Programming concepts and Java programming fundamentals.

---

## 2. Features

- Create a new bank account
- View account details
- Deposit money
- Withdraw money
- Transfer money between accounts
- Check account balance
- View transaction history
- View all accounts
- Validate user input
- Handle invalid numeric input without terminating the program

---

## 3. Technologies Used

- **Programming Language:** Java
- **Java Collections:** ArrayList
- **Interface:** Command Line / Terminal
- **Required JDK:** JDK 8 or later
- **External Libraries:** None

---

## 4. Project Structure

```text
BankingManagementSystem/
│
├── Main.java
├── BankAccount.java
└── README.md
```

### Main.java

Contains the main program, menu system, user input handling, account creation, account searching, and calls to banking operations.

### BankAccount.java

Contains the BankAccount class and the methods for deposit, withdrawal, transfer, balance checking, account details, and transaction history.

---

## 5. Environment Setup

### Prerequisites

Install Java Development Kit (JDK) version 8 or later.

To check whether Java is installed, open a terminal and run:

```bash
java -version
```

To check whether the Java compiler is installed, run:

```bash
javac -version
```

If both commands display a Java version, the environment is ready.

---

## 6. Dependencies

This project does not require any external dependencies or third-party libraries.

It uses only standard Java classes, including:

- `java.util.ArrayList`
- `java.util.Scanner`

---

## 7. Configuration

No additional configuration is required.

The project does not require:

- Database setup
- API keys
- Environment variables
- External services
- Internet connection

The application runs directly from the command line.

---

## 8. Compilation

Open a terminal in the project root directory, where `Main.java` and `BankAccount.java` are located.

Compile both Java files using:

```bash
javac Main.java BankAccount.java
```

If there are no compilation errors, the project has been compiled successfully.

---

## 9. Execution

After successful compilation, run the application using:

```bash
java Main
```

The main menu will appear in the terminal.

Example:

```text
====================================
       BANKING MANAGEMENT SYSTEM
====================================

========== MAIN MENU ==========
1. Create Account
2. View Account Details
3. Deposit Money
4. Withdraw Money
5. Transfer Money
6. Check Balance
7. Transaction History
8. View All Accounts
0. Exit
===============================
Enter your choice:
```

---

## 10. How to Use the Application

### 1. Create Account

Select option `1`.

Enter:

- Account number
- Account holder name
- Initial deposit

The new account will be added to the system.

### 2. View Account Details

Select option `2` and enter the account number.

The application displays the account number, account holder name, and current balance.

### 3. Deposit Money

Select option `3`.

Enter the account number and the amount to deposit.

The balance will be updated.

### 4. Withdraw Money

Select option `4`.

Enter the account number and withdrawal amount.

The application checks whether sufficient balance is available before completing the withdrawal.

### 5. Transfer Money

Select option `5`.

Enter:

- Sender account number
- Receiver account number
- Transfer amount

The amount is deducted from the sender and added to the receiver.

### 6. Check Balance

Select option `6` and enter the account number.

The current balance will be displayed.

### 7. Transaction History

Select option `7`.

Enter an account number to view its transaction history.

### 8. View All Accounts

Select option `8`.

The application displays all accounts created during the current program execution.

### 0. Exit

Select option `0` to close the application.

---

## 11. Java Concepts Demonstrated

### Classes and Objects

`BankAccount` is a class, and every account created by the user is an object of that class.

### Encapsulation

Account information such as account number, name, and balance is stored using private variables.

### Constructor

The constructor initializes the account details when a new BankAccount object is created.

### ArrayList

`ArrayList` is used to store multiple bank accounts and transaction records.

### Methods

Separate methods are used for operations such as:

- Deposit
- Withdraw
- Transfer
- Check balance
- Display details
- Transaction history

### Control Statements

The project uses:

- `if-else`
- `switch`
- `for` loops
- `do-while` loop

### Exception Handling

`try-catch` is used to handle invalid numeric input and prevent the program from terminating unexpectedly.

---

## 12. Validation and Error Handling

The application checks for common invalid operations, including:

- Negative or zero deposit amount
- Negative or zero withdrawal amount
- Withdrawal greater than available balance
- Negative initial balance
- Duplicate account numbers
- Non-existent account numbers
- Transfer to the same account
- Invalid menu choices
- Invalid numeric input

---

## 13. Data Storage

The current version stores account and transaction information in memory using `ArrayList`.

Therefore, the data is available while the program is running.

When the application is closed, the data is not permanently stored.

---

## 14. Limitations

- No database is used.
- No login or PIN authentication is implemented.
- Account data is not permanently stored.
- The application is command-line based.
- It is an educational project and is not intended for real banking transactions.

---

## 15. Future Enhancements

The project can be extended by adding:

- User login and PIN authentication
- Database storage
- Permanent account records
- Account deletion
- Interest calculation
- Admin panel
- Graphical User Interface (GUI)
- Detailed transaction reports

---

## 16. Author

**Student Project**

**Project:** Banking Management System
