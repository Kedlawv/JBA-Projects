package contacts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String name;
        String surname;
        String number;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the person: ");
        name = scanner.next();
        System.out.println("Enter the surname of the person: ");
        surname = scanner.next();
        System.out.println("Enter the number: ");
        number = scanner.next();

        Record record = new Record(name, surname, number);
        phoneBook.addRecord(record);

        System.out.println("A record created!");
        System.out.println("-------> " + phoneBook.getAllRecords().get(0));

    }
}
