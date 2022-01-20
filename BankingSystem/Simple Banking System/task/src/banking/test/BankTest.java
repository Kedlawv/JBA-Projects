package banking.test;

import banking.Model.Account;
import banking.Model.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void accNoIs9DigitsWith235(){

        String accNo = getAccountWithStartingNumPlusOne(235).getAccNo();

        System.out.println(accNo);
        assertEquals(9, accNo.length());
    }

    @Test
    public void accNoIs9DigitsWith0(){

        String accNo = getAccountWithStartingNumPlusOne(0).getAccNo();

        System.out.println(accNo);
        assertEquals(9, accNo.length());
    }

    @Test
    public void accNoIs9DigitsWith123456789(){

        String accNo = getAccountWithStartingNumPlusOne(123456789).getAccNo();

        System.out.println(accNo);
        assertEquals(9, accNo.length());
    }

    @Test
    public void cardNumberIs16Digits(){
        String cardNo1 = getAccountWithStartingNumPlusOne(0).getCard().getNumber();
        String cardNo2 = getAccountWithStartingNumPlusOne(456).getCard().getNumber();
        String cardNo3 = getAccountWithStartingNumPlusOne(7436462).getCard().getNumber();
        System.out.println(cardNo1);
        System.out.println(cardNo2);
        System.out.println(cardNo3);

        assertEquals(16,cardNo1.length());
        assertEquals(16,cardNo2.length());
        assertEquals(16,cardNo3.length());
    }

    @Test
    public void pinNumberIs4digitsInRange0000To9999(){
        String pinNo1 = getAccountWithStartingNumPlusOne(0).getCard().getPin();
        String pinNo2 = getAccountWithStartingNumPlusOne(0).getCard().getPin();
        String pinNo3 = getAccountWithStartingNumPlusOne(0).getCard().getPin();

        System.out.println(pinNo1);
        System.out.println(pinNo2);
        System.out.println(pinNo3);

        assertTrue(validatePin(pinNo1));
        assertTrue(validatePin(pinNo2));
        assertTrue(validatePin(pinNo3));
    }

    public Account getAccountWithStartingNumPlusOne(int num){
        Bank bank = new Bank();
        Bank.accNoInc = num;
        bank.createNewAccount();
        Account account = bank.getAccounts().get(0);
        return account;
    }

    public boolean validatePin(String pin){
        boolean is4digits = pin.length() == 4;
        int pinNum = Integer.parseInt(pin);
        return is4digits && (pinNum >= 0 && pinNum <= 9999);
    }
}
