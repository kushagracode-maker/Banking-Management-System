public class Main {
    static BankManager bankManager = new BankManager();

    public static void main(String[] args) {

        int choice;
        System.out.println("====================================");
        System.out.println("       BANKING MANAGEMENT SYSTEM");
        System.out.println("====================================");

        do{
            showMenu();
            choice =InputValidator.readInt("Enter your choice: ");

            switch (choice) {
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
        } while(choice !=0);
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
                InputValidator.readString("Enter account number: ");

        if(bankManager.findAccount(accountNumber) !=null){
            System.out.println("Account number already exists.");
            return;
        }
        String name=
                InputValidator.readString("Enter account holder name: ");

        double initialBalance=
                InputValidator.readDouble("Enter initial deposit: ");
        if(initialBalance <0){
            System.out.println("Initial balance cannot be negative.");
            return;
        }
        BankAccount account=
                new BankAccount(accountNumber, name, initialBalance);

        bankManager.addAccount(account);
        System.out.println("Account created successfully!");
    }
    static void viewAccount(){

        String accountNumber=
                InputValidator.readString("Enter account number: ");

        BankAccount account=
                bankManager.findAccount(accountNumber);

        if(account ==null){
            System.out.println("Account not found.");
            return;
        }
        account.displayDetails();
    }
    static void depositMoney(){

        String accountNumber =
                InputValidator.readString("Enter account number: ");

        BankAccount account =
                bankManager.findAccount(accountNumber);

        if(account == null){
            System.out.println("Account not found.");
            return;
        }

        double amount =
                InputValidator.readDouble("Enter amount to deposit: ");

        account.deposit(amount);
    }

    static void withdrawMoney(){

        String accountNumber=
                InputValidator.readString("Enter account number: ");

        BankAccount account=
                bankManager.findAccount(accountNumber);

        if(account == null){
            System.out.println("Account not found.");
            return;
        }
        double amount =
                InputValidator.readDouble("Enter amount to withdraw: ");
        account.withdraw(amount);
    }
    static void transferMoney(){

        String senderNumber=
                InputValidator.readString(
                        "Enter sender account number: "
                );
        String receiverNumber=
                InputValidator.readString(
                        "Enter receiver account number: "
                );

        BankAccount sender=
                bankManager.findAccount(senderNumber);

        BankAccount receiver=
                bankManager.findAccount(receiverNumber);

        if(sender == null){
            System.out.println("Sender account not found.");
            return;
        }
        if(receiver == null){
            System.out.println("Receiver account not found.");
            return;
        }

        if(sender == receiver){
            System.out.println(
                    "Sender and receiver cannot be the same."
            );
            return;
        }
        double amount =
                InputValidator.readDouble(
                        "Enter amount to transfer: "
                );
        sender.transfer(receiver, amount);
    }
    static void checkBalance(){

        String accountNumber =
                InputValidator.readString("Enter account number: ");
        BankAccount account =
                bankManager.findAccount(accountNumber);

        if(account == null){
            System.out.println("Account not found.");
            return;
        }
        account.checkBalance();
    }
    static void showTransactions(){

        String accountNumber =
                InputValidator.readString("Enter account number: ");
        BankAccount account =
                bankManager.findAccount(accountNumber);
        if (account == null){
            System.out.println("Account not found.");
            return;
        }
        account.showTransactions();
    }
    static void showAllAccounts(){

        System.out.println();
        System.out.println("========== ALL ACCOUNTS ==========");

        if (bankManager.getAccounts().isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        for (BankAccount account : bankManager.getAccounts()){
            account.displayDetails();
        }
    }
}