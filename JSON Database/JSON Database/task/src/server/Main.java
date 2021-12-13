package server;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String command = null;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            int index = 0;

            try {
                command = scanner.next();
                if (!"exit".equals(command)) {
                    index = scanner.nextInt() - 1;
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getClass() + " BAD INPUT!!!!!");
                continue;
            }

            switch (command) {
                case "get":
                    InputProcessor.get(index, scanner);
                    break;
                case "set":
                    InputProcessor.set(index, scanner);
                    break;
                case "delete":
                    InputProcessor.delete(index, scanner);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Command does not exist => " + command);
            }
        }
    }
}
