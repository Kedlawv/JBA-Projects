package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class App {

    PhoneBook phoneBook = new PhoneBook();

    boolean exit = false;
    String action;

    Scanner scanner = new Scanner(System.in);

    public void run() {

        while (!exit) {
            System.out.println("Enter action (add, remove, edit, count, info, exit)");
            action = scanner.next();
            switch (action) {
                case "exit":
                    exit = true;
                    break;

                case "add":
                    System.out.println("Enter the type (person, organization):");
                    String recordType = getInput();

                    if (recordType.equals("person")) {
                        addPerson();
                    } else if (recordType.equals("organization")) {
                        addOrganization();
                    } else {
                        System.out.println("Not a valid choice!");
                    }
                    System.out.println();
                    break;

                case "remove":
                    if (phoneBook.getNumberOfRecords() < 1) {
                        System.out.println("\nNo records to remove!");
                        break;
                    }

                    listRecords(phoneBook.getAllRecords());
                    System.out.print("Select a record: > ");
                    int selectedRemoveIndex = scanner.nextInt() - 1;

                    if (isValidIndex(selectedRemoveIndex)) {
                        Record removed = phoneBook.removeRecord(selectedRemoveIndex);
                        removed.setEditDateTime(LocalDateTime.now());
                        System.out.println("Record \n[" + removed + "] was removed.");
                    } else {
                        System.out.println("You selected an invalid record!");
                    }
                    System.out.println();
                    break;

                case "edit":
                    if (phoneBook.getNumberOfRecords() < 1) {
                        System.out.println("\nNo records to edit!");
                        break;
                    }

                    listRecords(phoneBook.getAllRecords());

                    int selectedEditIndex = getValidIndex();
                    Record recordToEdit = phoneBook.getRecordByIndex(selectedEditIndex);

                    if (recordToEdit.getClass() == PersonRecord.class) {
                        editPerson((PersonRecord) recordToEdit);
                    } else if (recordToEdit.getClass() == OrganizationRecord.class) {
                        editOrganization((OrganizationRecord) recordToEdit);
                    } else {
                        System.out.println("Something went wrong. Please try again.");
                    }

                    System.out.println("Record updated "
                            + phoneBook.getRecordByIndex(selectedEditIndex));
                    recordToEdit.setEditDateTime(LocalDateTime.now());
                    System.out.println();
                    break;


                case "count":
                    System.out.printf("Phone book has %d records\n", phoneBook.getNumberOfRecords());
                    System.out.println();
                    break;

                case "info":
                    if (phoneBook.getNumberOfRecords() > 0) {
                        listRecords(phoneBook.getAllRecords());
                        System.out.println("Select a record: ");
                        int selectedInfoIndex = getValidIndex();
                        Record recordToInfo = phoneBook.getRecordByIndex(selectedInfoIndex);
                        System.out.println(recordToInfo);
                    } else {
                        System.out.println("No records to list!");
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("No such action");
                    break;
            }
        }
    }

    private void editOrganization(OrganizationRecord recordToEdit) {
        String fieldChoice = getValidOrgField();

        switch (fieldChoice) {
            case "name":
                System.out.println("Enter a new name: ");
                String newName = getInput();
                recordToEdit.setOrgName(newName);
                break;
            case "address":
                System.out.println("Enter new surname: ");
                String newAddress = getInput();
                recordToEdit.setAddress(newAddress);
                break;
            case "number":
                System.out.println("Enter new number: ");
                String newNumber = getInput();
                recordToEdit.setNumber(newNumber);
                break;

            default:
                System.out.println("Not a valid field!");
                break;
        }
    }

    private void editPerson(PersonRecord recordToEdit) {
        String fieldChoice = getValidPersonField();

        switch (fieldChoice) {
            case "name":
                System.out.println("Enter a new name: ");
                String newName = getInput();
                recordToEdit.setName(newName);
                break;
            case "surname":
                System.out.println("Enter new surname: ");
                String newSurname = getInput();
                recordToEdit.setSurname(newSurname);
                break;
            case "number":
                System.out.println("Enter new number: ");
                String newNumber = getInput();
                recordToEdit.setNumber(newNumber);
                break;
            case "birth date":
                System.out.println("Enter new birth date");
                recordToEdit.setBirthDate(scanner.nextLine());
            case "gender":
                System.out.println("Enter new gender");
                recordToEdit.setGender(getGender());
            default:
                System.out.println("Not a valid field!");
                break;
        }
    }

    private void addPerson() {
        PersonRecord person = new PersonRecord();

        System.out.println("Enter the name of the person: ");
        person.setName(scanner.next());

        System.out.println("Enter the surname of the person: ");
        person.setSurname(scanner.next());

        System.out.println("Enter the birth date: ");
        person.setBirthDate(scanner.nextLine().trim());

        System.out.println("Enter the gender: ");
        person.setGender(scanner.nextLine().trim());

        System.out.println("Enter the number: ");
        person.setNumber(scanner.nextLine().trim());

        boolean isAdded = phoneBook.addRecord(person);
        System.out.println(isAdded ? "The record added." : "Record was not added.");
    }

    private void addOrganization() {
        OrganizationRecord org = new OrganizationRecord();

        System.out.print("Enter the organization name: > ");
        org.setOrgName(getInput());

        System.out.print("Enter the address: > ");
        org.setAddress(getInput());

        System.out.print("Enter the number: > ");
        org.setNumber(getInput());


        boolean isAdded = phoneBook.addRecord(org);
        System.out.println(isAdded ? "The record added." : "Record was not added.");
    }

    private String getGender() {
        return scanner.nextLine();
    }

    private String getNonEmptyInput() {
        String input;
        do {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("\nPlease input a valid value.");
            }
        } while (input.isEmpty());

        return input;
    }

    private String getInput(){
        return scanner.next();
    }

    private LocalDate getValidDate() {
        LocalDate date = null;
        String input;

        do {
            input = scanner.nextLine();

            if(input.equals("")){
                break;
            }

            try {
                date = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("\nPlease input a valid value.");
            }
        } while (date == null);

        return date;
    }

    private int getValidIndex() {
        int selectedEditIndex = -1;
        do {
            System.out.print("Select a record: > ");
            selectedEditIndex = scanner.nextInt() - 1;
            if (!isValidIndex(selectedEditIndex)) {
                System.out.println("Not a valid index!");
            }
        } while (!isValidIndex(selectedEditIndex));

        return selectedEditIndex;
    }

    private String getValidPersonField() {
        String selectedField = "";
        do {
            System.out.print("Select a field (name, surname, birth date, gender, number): > ");
            selectedField = scanner.nextLine();
            if (!isValidPersonField(selectedField)) {
                System.out.println("Not a valid field!");
            }
        } while (!isValidPersonField(selectedField));

        return selectedField;
    }

    private boolean isValidPersonField(String field) {
        return field.equals("name") || field.equals("surname") || field.equals("number")
                || field.equals("birth date") || field.equals("gender");
    }

    private String getValidOrgField() {
        String selectedField = "";
        do {
            System.out.print("Select a field (name, address, number): > ");
            selectedField = scanner.nextLine();
            if (!isValidOrgField(selectedField)) {
                System.out.println("Not a valid field!");
            }
        } while (!isValidOrgField(selectedField));

        return selectedField;
    }

    private boolean isValidOrgField(String field) {
        return field.equals("name") || field.equals("address") || field.equals("number");
    }

    private boolean isValidIndex(int selectedRecord) {
        return selectedRecord >= 0 && selectedRecord < phoneBook.getNumberOfRecords();
    }


    private void listRecords(List<Record> records) {

        for (int i = 0; i < records.size(); i++) {
            Class<? extends Record> recordClass = records.get(i).getClass();

            if (recordClass == PersonRecord.class) {
                PersonRecord personRecord= (PersonRecord)records.get(i);
                System.out.println(i + 1 + ". " + personRecord.getName() + " "
                        + personRecord.getSurname());
            } else if (recordClass == OrganizationRecord.class) {
                System.out.println(i + 1 + ". " + ((OrganizationRecord) records.get(i)).getOrgName());
            } else {
                System.out.println("Something went wrong. Please try again.");
            }
        }
    }
}
