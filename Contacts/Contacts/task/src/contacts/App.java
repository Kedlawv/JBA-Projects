package contacts;

import java.util.List;
import java.util.Scanner;

public class App {

    public void run() {
        PhoneBook phoneBook = new PhoneBook();
        String name;
        String surname;
        String number;
        boolean exit = false;
        String action;

        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Enter action (add, remove, edit, count, list, exit)");
            action = scanner.next();
            switch (action) {
                case "exit":
                    exit = true;
                    break;

                case "add":
                    System.out.print("Enter the name of the person: > ");
                    name = getNonEmptyInput(scanner);

                    System.out.print("Enter the surname of the person: > ");
                    surname = getNonEmptyInput(scanner);

                    System.out.print("Enter the number: > ");
                    number = getNonEmptyInput(scanner);

                    Record record = new Record(name, surname, number);
                    boolean isAdded = phoneBook.addRecord(record);
                    System.out.println(isAdded ? "The record added." : "Record was not added.");
                    break;

                case "remove":
                    if (phoneBook.getNumberOfRecords() < 1) {
                        System.out.println("\nNo records to remove!");
                        break;
                    }

                    listRecords(phoneBook.getAllRecords());
                    System.out.print("Select a record: > ");
                    int selectedRemoveIndex = scanner.nextInt() - 1;

                    if (isValidIndex(phoneBook.getNumberOfRecords(), selectedRemoveIndex)) {
                        Record removed = phoneBook.removeRecord(selectedRemoveIndex);
                        System.out.println("Record [" + removed + "] was removed.");
                    } else {
                        System.out.println("You selected an invalid record!");
                    }
                    break;

                case "edit":
                    if (phoneBook.getNumberOfRecords() < 1) {
                        System.out.println("\nNo records to edit!");
                        break;
                    }

                    listRecords(phoneBook.getAllRecords());

                    int selectedEditIndex = getValidIndex(scanner, phoneBook);

                    String fieldChoice = getValidField(scanner);
                    Record recordToEdit = phoneBook.getRecordByIndex(selectedEditIndex);

                    switch (fieldChoice) {
                        case "name":
                            System.out.println("Enter a new name: > ");
                            String newName = getNonEmptyInput(scanner);
                            recordToEdit.setName(newName);
                            break;
                        case "surname":
                            System.out.println("Enter new surname: > ");
                            String newSurname = getNonEmptyInput(scanner);
                            recordToEdit.setSurname(newSurname);
                            break;
                        case "number":
                            System.out.println("Enter new number: > ");
                            String newNumber = getNonEmptyInput(scanner);
                            recordToEdit.setNumber(newNumber);
                            break;
                        default:
                            System.out.println("Not a valid field!");
                            break;
                    }

                    System.out.println("Record updated "
                            + phoneBook.getRecordByIndex(selectedEditIndex));
                    break;

                case "count":
                    System.out.printf("Phone book has %d records\n", phoneBook.getNumberOfRecords());
                    break;

                case "list":
                    if (phoneBook.getNumberOfRecords() > 0) {
                        listRecords(phoneBook.getAllRecords());
                    } else {
                        System.out.println("No records to list!");
                    }
                    break;

                default:
                    System.out.println("No such action");
                    break;
            }
        }
    }

    private String getNonEmptyInput(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("\nPlease input a valid value.");
            }
        } while (input.isEmpty());

        return input;
    }

    private int getValidIndex(Scanner scanner, PhoneBook phoneBook) {
        int selectedEditIndex = -1;
        do {
            System.out.print("Select a record: > ");
            selectedEditIndex = scanner.nextInt() - 1;
            if(!isValidIndex(phoneBook.getNumberOfRecords(), selectedEditIndex)){
                System.out.println("Not a valid index!");
            }
        } while (!isValidIndex(phoneBook.getNumberOfRecords(), selectedEditIndex));

        return selectedEditIndex;
    }

    private String getValidField(Scanner scanner) {
        String selectedField = "";
        do {
            System.out.print("Select a field (name, surname, number): > ");
            selectedField = scanner.nextLine();
            if(!isValidField(selectedField)){
                System.out.println("Not a valid field!");
            }
        } while (!isValidField(selectedField));

        return selectedField;
    }

    private boolean isValidIndex(int size, int selectedRecord) {
        return selectedRecord >= 0 && selectedRecord < size;
    }

    private boolean isValidField(String field) {
        return field.equals("name") || field.equals("surname") || field.equals("number");
    }

    private void listRecords(List<Record> records) {
        for (int i = 0; i < records.size(); i++) {
            System.out.println(i + 1 + ". " + records.get(i));
        }
    }
}
