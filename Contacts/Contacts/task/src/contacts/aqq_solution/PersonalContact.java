package contacts.aqq_solution;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PersonalContact extends Contact {
    private String name;
    private String surname;
    private Character gender;
    private LocalDate birthDate;

    public PersonalContact(PersonalContactDetailsFactory detailsFactory) {
        this.name = detailsFactory.createName();
        this.surname = detailsFactory.createSurname();
        this.birthDate = detailsFactory.createDateOfBirth();
        this.gender = detailsFactory.createGender();
        super.number = detailsFactory.createNumber();
        super.createdAt = detailsFactory.setCreatedAt();
        super.lastEdit = super.createdAt;
    }

    @Override
    public String toString() {
            return this.nameToString() + " " + this.surnameToString();
    }

    private String nameToString() {
        return this.name != null ? this.name : "";
    }

    private String surnameToString() {
        return this.surname != null ? this.surname : "";
    }

    private String genderToString() {
        return (this.gender != null ? String.valueOf(this.gender) : "[no data]");
    }

    private String birthDateToString() {
        return (this.birthDate != null ? String.valueOf(this.birthDate) : "[no data]");
    }


    @Override
    public String printContactInfo() {
        return "Name: " + this.nameToString() +
                "\nSurname: " + this.surnameToString() +
                "\nBirth date: " + birthDateToString() +
                "\nGender: " + genderToString() +
                "\n" + super.toString();
    }

    @Override
    public void editContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a field (name, surname, birth, gender, number)");

        switch (scanner.nextLine().toLowerCase()) {
            case "name":
                this.editName(scanner);
                break;
            case "surname":
                this.editSurname(scanner);
                break;
            case "birth":
                this.editBirthDate();
                break;
            case "gender":
                this.editGender();
                break;
            case "number":
                super.editNumber();
                break;
            default:
                System.out.println("invalid input");
        }
        super.lastEdit = LocalDateTime.now();
        scanner.close();
    }

    private void editName(Scanner sc) {
        System.out.println("Enter the name:");
        this.name = sc.nextLine();
        System.out.println("The record updated!");
    }

    private void editSurname(Scanner sc) {
        System.out.println("Enter the surname:");
        this.name = sc.nextLine();
        System.out.println("The record updated!");
    }

    private void editGender() {
        Validator validator = new GenderValidator();
        String gender = ContactUtils.initiateDialogue("Enter the gender (M, F):", validator,
                "The record updated!", "Bad gender!");
        this.gender = gender == null ? null : Character.toUpperCase(gender.charAt(0));
    }

    private void editBirthDate() {
        Validator validator = new DateValidator();
        String date = ContactUtils.initiateDialogue("Enter the birth date:", validator,
                "The record updated!", "Bad birth date!");
        this.birthDate =  date.isEmpty() ? null : LocalDate.parse(date);
    }


}