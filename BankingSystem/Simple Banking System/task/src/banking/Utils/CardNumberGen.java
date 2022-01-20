package banking.Utils;

import banking.Model.Card;

import java.util.Random;

public class CardNumberGen {
    public static Card generateNewCard(String bin, String accNo){
        String cardNo = bin + accNo + 5;
        String pin = String.format("%04d",new Random().nextInt(10000));
        Card card = new Card(cardNo);
        card.setPin(pin);
        return card;
    }
}
