package banking.Model;

public class Card {
    private final String number;
    private String pin;

    public Card(String number){
        this.number = number;
    }

    public String getNumber(){
        return this.number;
    }

    public String getPin(){
        return this.pin;
    }

    public void setPin(String newPin){
        this.pin = newPin;
    }
}
