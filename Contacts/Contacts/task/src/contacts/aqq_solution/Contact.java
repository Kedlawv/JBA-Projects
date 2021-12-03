package contacts.aqq_solution;

import java.time.LocalDateTime;

public abstract class Contact {
    protected String number;
    protected LocalDateTime createdAt;
    protected LocalDateTime lastEdit;

    public String toString() {
        return "Number: " + (number.equals("") ? "[no number]" : this.number) +
                "\nTime created: " + this.createdAt +
                "\nTime last edit: " + this.lastEdit;
    }

    public abstract String printContactInfo();

    public abstract void editContact();

    protected void editNumber() {
        Validator validator = new PhoneNumberValidator();
        String number = ContactUtils.initiateDialogue("Enter the number:", validator,
                "The record updated!", "Wrong number format!\nThe record updated!");
        this.number = number.isEmpty() ? "" : number;
    }

}