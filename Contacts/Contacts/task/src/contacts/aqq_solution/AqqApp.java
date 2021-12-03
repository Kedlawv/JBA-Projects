package contacts.aqq_solution;

import java.util.Scanner;

public class AqqApp {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        boolean running = true;

        while (running) {
            System.out.println("\nEnter action (add, remove, edit, count, info, exit):");
            switch (scanner.nextLine()) {
                case "add":
                    UserServiceImpl.createContact(user, scanner);
                    break;
                case "remove":
                    UserServiceImpl.removeContact(user, scanner);
                    break;
                case "edit":
                    UserServiceImpl.editContact(user, scanner);
                    break;
                case "count":
                    UserServiceImpl.countContacts(user);
                    break;
                case "info":
                    UserServiceImpl.displayContactInfo(user, scanner);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}