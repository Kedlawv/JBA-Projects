package banking.Model;

import banking.Utils.CardNumberGen;

public class Account {
    private final String bin = "400000";
    private final String accNo;
    private final Card card;

    public Account(){
        accNo = String.format("%09d",Bank.getNextAccNo());
        this.card = CardNumberGen.generateNewCard(bin,accNo);
    }

    public Card getCard(){
        return this.card;
    }

    public String getBin() {
        return bin;
    }

    public String getAccNo() {
        return accNo;
    }
}
