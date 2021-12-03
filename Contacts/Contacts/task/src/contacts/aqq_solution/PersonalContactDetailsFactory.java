package contacts.aqq_solution;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PersonalContactDetailsFactory {
    private Scanner sc = new Scanner(System.in);

    public String createName() {
        System.out.println("Enter the name:");
        return sc.nextLine();
    }

    public String createSurname() {
        System.out.println("Enter the surname:");
        return sc.nextLine();
    }

    public Character createGender() {
        Validator validator = new GenderValidator();
        String gender = ContactUtils.initiateDialogue("Enter the gender (M, F):", validator,
                "The record added.", "Bad gender!");
        return gender == null ? null : Character.toUpperCase(gender.charAt(0));
    }

    public LocalDate createDateOfBirth() {
        Validator validator = new DateValidator();
        String date = ContactUtils.initiateDialogue("Enter the birth date:", validator,
                "The record added.", "Bad birth date!");
        return date == null ? null : LocalDate.parse(date);
    }

    public String createNumber() {
        Validator validator = new PhoneNumberValidator();
        String number = ContactUtils.initiateDialogue("Enter the number:", validator,
                "The record added.", "Wrong number format!\nThe record added.");
        return number == null ? "" : number;
    }

    public LocalDateTime setCreatedAt() {
        return LocalDateTime.now();
    }

}