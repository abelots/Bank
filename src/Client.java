import java.sql.SQLOutput;
import java.util.ArrayList;

public class Client extends User{

    private ArrayList<Account> accounts=new ArrayList<Account>();

    int createAccount(Currency x) {
        Account account=new Account(x);
        accounts.add(account);
        return account.getId();
    }

    void showAllAсcounts(){
        for (int i = 0; i < accounts.size(); i++) {
            System.out.print(accounts.get(i).getId() + " ");
            System.out.print(accounts.get(i).getAmount()+ " ");
            System.out.println(accounts.get(i).getCurrencyName());
        }
    }

    void deleteAccount(int id){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId()==id) accounts.remove(i);
        }
    }

    Account getAccount(int id){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId()==id) return accounts.get(i);
        }
        return null;
    }


    public Client(String login,String password) {
        super(login, password);
    }
}
