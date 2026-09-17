import java.util.ArrayList;

public class BankAccount{

    private String accountNumber;
    private String name;
    private double balance;

    private ArrayList<Transaction>transactions;

    public BankAccount(String accountNumber, String name, double balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;

        transactions = new ArrayList<>();
        transactions.add(
                new Transaction("Account created with Rs. " + balance)
        );
    }
    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Amount must be greater than 0.");
            return;
        }
        balance = balance + amount;
        transactions.add(
                new Transaction("Deposited Rs. " + amount)
        );
        System.out.println("Money deposited successfully.");
        System.out.printf("New balance: Rs. %.2f%n", balance);
    }
    public void withdraw(double amount) {
        if(amount <= 0){
            System.out.println("Amount must be greater than 0.");
            return;
        }
        if(amount > balance){
            System.out.println("Insufficient balance.");
            return;
        }
        balance = balance - amount;
        transactions.add(
                new Transaction("Withdrawn Rs. " + amount)
        );
        System.out.println("Money withdrawn successfully.");
        System.out.printf("New balance: Rs. %.2f%n", balance);
    }
    public boolean transfer(BankAccount receiver, double amount){
        if(amount <= 0){
            System.out.println("Amount must be greater than 0.");
            return false;
        }
        if(amount > balance){
            System.out.println("Insufficient balance.");
            return false;
        }
        balance = balance - amount;
        receiver.balance = receiver.balance + amount;
        transactions.add(
                new Transaction(
                        "Transferred Rs. " + amount +
                                " to account " + receiver.accountNumber
                )
        );
        receiver.transactions.add(
                new Transaction(
                        "Received Rs. " + amount +
                                " from account " + accountNumber
                )
        );
        System.out.println("Money transferred successfully.");
        System.out.printf(
                "Your new balance: Rs. %.2f%n",
                balance
        );
        return true;
    }
    public void displayDetails(){
        System.out.println(
                "\n========== ACCOUNT DETAILS =========="
        );
        System.out.println(
                "Account Number : " + accountNumber
        );
        System.out.println(
                "Account Holder : " + name
        );
        System.out.printf(
                "Balance      : Rs. %.2f%n",
                balance
        );
    }
    public void checkBalance(){
        System.out.printf(
                "Current Balance: Rs. %.2f%n",
                balance
        );
    }
    public void showTransactions(){
        System.out.println(
                "\n========== TRANSACTION HISTORY =========="
        );
        if(transactions.isEmpty()){
            System.out.println("No transactions found.");
            return;
        }
        for(Transaction transaction : transactions){
            System.out.println("- " + transaction.getDescription());
        }
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
}