package banking.Model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public static int accNoInc = 0;

    List<Account> accounts = new ArrayList<>();

    public Bank(){

    }
    public static int getNextAccNo(){
        return ++accNoInc;
    }

    public void createNewAccount(){
        accounts.add(new Account());
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
