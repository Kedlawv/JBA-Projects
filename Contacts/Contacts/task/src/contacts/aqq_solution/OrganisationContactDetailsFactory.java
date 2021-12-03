package contacts.aqq_solution;

import java.time.LocalDateTime;
import java.util.Scanner;

public class OrganisationContactDetailsFactory {
    private Scanner sc = new Scanner(System.in);

    public String createOrganisationName() {
        System.out.println("Enter the organization name:");
        return sc.nextLine();
    }

    public String createAddress() {
        System.out.println("Enter the address:");
        return sc.nextLine();
    }

    public String createNumber() {
        Validator validator = new PhoneNumberValidator();
        String number = ContactUtils.initiateDialogue("Enter the number:", validator,
                "The record added.", "Wrong number format!\nThe record added.");
        return number.isEmpty() ? "" : number;
    }

    public LocalDateTime setCreatedAt() {
        return LocalDateTime.now();
    }

}