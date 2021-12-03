package contacts.aqq_solution;

import java.util.Scanner;

public class UserServiceImpl {

    public static void createContact(User user, Scanner scanner) {
        System.out.println("Enter the type (person, organization):");
        String input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "person":
                ContactFactory persContactFactory = new PersonalContactFactory();
                Contact persContact = persContactFactory.createContact();
                user.addContact(persContact);
                break;
            case "organization":
                ContactFactory orgContactFactory = new OrganisationContactFactory();
                Contact orgContact = orgContactFactory.createContact();
                user.addContact(orgContact);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public static void removeContact(User user, Scanner scanner) {
        Integer index = initiateUserDialogue(user, scanner,
                "Select a record:", "No records to remove!");
        if (index != -1) {
            user.removeContactByIndex(index - 1);
            System.out.println("The record removed!");
        }
    }

    public static void editContact(User user, Scanner scanner) {
        Integer index = initiateUserDialogue(user, scanner,
                "Select a record:", "No records to edit!");
        if (index != -1) {
            Contact selectedContact = user.findContactByIndex(index - 1);
            selectedContact.editContact();
        }
    }

    public static void countContacts(User user) {
        System.out.println("The Phone Book has " + user.contactListSize() + " records.");
    }

    public static void displayContactList(User user) {
        int i = 1;
        for (Contact contact : user.getContactList()) {
            System.out.println(i++ + ". " + contact.toString());
        }
    }

    public static void displayContactInfo(User user, Scanner scanner) {
        Integer index = initiateUserDialogue(user, scanner,
                "Enter index to show info:", "No records to view!");
        if (index != -1) {
            Contact selectedContact = user.findContactByIndex(index - 1);
            System.out.println(selectedContact.printContactInfo());
        }
    }

    public static Integer initiateUserDialogue(User user, Scanner scanner, String posResponse, String negResponse) {
        Integer record;
        if (user.contactListSize() == 0) {
            System.out.println(negResponse);
            record = -1;
        } else {
            displayContactList(user);
            System.out.println(posResponse);
            record = Integer.parseInt(scanner.nextLine());
        }
        return record;
    }

}