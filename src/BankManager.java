import java.util.ArrayList;

public class BankManager{

    private ArrayList<BankAccount>accounts;

    public BankManager(){
        accounts= new ArrayList<>();
    }
    public void addAccount(BankAccount account){
        accounts.add(account);
    }
    public BankAccount findAccount(String accountNumber){
        for (BankAccount account : accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }
    public ArrayList<BankAccount> getAccounts(){
        return accounts;
    }
}