import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<BankAccount>accounts = new ArrayList<>();

    public static void main(String[] args){

        int choice;
        System.out.println("====================================");
        System.out.println("       BANKING MANAGEMENT SYSTEM");
        System.out.println("====================================");

        do{
            showMenu();
            choice =readInt("Enter your choice: ");

            switch (choice){

                case 1:
                    createAccount();
                    break;

                case 2:
                    viewAccount();
                    break;

                case 3:
                    depositMoney();
                    break;

                case 4:
                    withdrawMoney();
                    break;

                case 5:
                    transferMoney();
                    break;

                case 6:
                    checkBalance();
                    break;

                case 7:
                    showTransactions();
                    break;

                case 8:
                    showAllAccounts();
                    break;

                case 0:
                    System.out.println();
                    System.out.println(
                            "Thank you for using the Banking Management System!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        } while (choice != 0);
        scanner.close();
    }
    static void showMenu(){

        System.out.println();

        System.out.println("========== MAIN MENU ==========");

        System.out.println("1. Create Account");

        System.out.println("2. View Account Details");

        System.out.println("3. Deposit Money");

        System.out.println("4. Withdraw Money");

        System.out.println("5. Transfer Money");

        System.out.println("6. Check Balance");

        System.out.println("7. Transaction History");

        System.out.println("8. View All Accounts");

        System.out.println("0. Exit");

        System.out.println("===============================");
    }

    static void createAccount(){

        System.out.println();
        System.out.println("========== CREATE ACCOUNT ==========");

        String accountNumber=
                readString("Enter account number: ");

        if(findAccount(accountNumber) !=null) {
            System.out.println(
                    "Account number already exists."
            );
            return;
        }
        String name=
                readString("Enter account holder name: ");

        double initialBalance=
                readDouble("Enter initial deposit: ");

        if(initialBalance <0){
            System.out.println(
                    "Initial balance cannot be negative."
            );
            return;
        }
        BankAccount account=
                new BankAccount(accountNumber, name, initialBalance);
        accounts.add(account);
        System.out.println(
                "Account created successfully!"
        );
    }

    static BankAccount findAccount(String accountNumber){
        for(BankAccount account : accounts){
            if(account.getAccountNumber()
                    .equals(accountNumber)){
                return account;
            }
        }
        return null;
    }
    static void viewAccount(){

        String accountNumber=
                readString("Enter account number: ");

        BankAccount account=
                findAccount(accountNumber);

        if(account == null){
            System.out.println("Account not found.");
            return;
        }
        account.displayDetails();
    }

    static void depositMoney(){

        String accountNumber=
                readString("Enter account number: ");

        BankAccount account=
                findAccount(accountNumber);

        if(account == null){
            System.out.println("Account not found.");
            return;
        }
        double amount=
                readDouble("Enter amount to deposit: ");
        account.deposit(amount);
    }
    static void withdrawMoney(){

        String accountNumber=
                readString("Enter account number: ");
        BankAccount account=
                findAccount(accountNumber);

        if(account == null){
            System.out.println("Account not found.");
            return;
        }
        double amount=
                readDouble("Enter amount to withdraw: ");
        account.withdraw(amount);
    }
    static void transferMoney(){

        String senderNumber=
                readString("Enter sender account number: ");

        String receiverNumber=
                readString("Enter receiver account number: ");

        BankAccount sender=
                findAccount(senderNumber);

        BankAccount receiver=
                findAccount(receiverNumber);

        if(sender == null){
            System.out.println(
                    "Sender account not found."
            );
            return;
        }
        if(receiver == null){
            System.out.println(
                    "Receiver account not found."
            );
            return;
        }
        if(sender ==receiver){

            System.out.println(
                    "Sender and receiver cannot be the same."
            );
            return;
        }
        double amount=
                readDouble("Enter amount to transfer: ");
        sender.transfer(receiver, amount);
    }
    static void checkBalance(){

        String accountNumber =
                readString("Enter account number: ");
        BankAccount account =
                findAccount(accountNumber);

        if(account == null){
            System.out.println("Account not found.");
            return;
        }
        account.checkBalance();
    }
    static void showTransactions(){

        String accountNumber =
                readString("Enter account number: ");

        BankAccount account =
                findAccount(accountNumber);

        if(account == null) {
            System.out.println("Account not found.");
            return;
        }
        account.showTransactions();
    }
    static void showAllAccounts(){

        System.out.println();
        System.out.println("========== ALL ACCOUNTS ==========");

        if(accounts.isEmpty()){
            System.out.println("No accounts available.");
            return;
        }
        for(BankAccount account : accounts){
            account.displayDetails();
        }
    }
    static int readInt(String message){
        while(true){
            try{
                System.out.print(message);
                return Integer.parseInt(
                        scanner.nextLine().trim()
                );
            } catch(NumberFormatException e){
                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
    static double readDouble(String message) {
        while (true){
            try{
                System.out.print(message);
                return Double.parseDouble(
                        scanner.nextLine().trim()
                );

            } catch(NumberFormatException e){
                System.out.println(
                        "Please enter a valid amount."
                );
            }
        }
    }
    static String readString(String message){
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}