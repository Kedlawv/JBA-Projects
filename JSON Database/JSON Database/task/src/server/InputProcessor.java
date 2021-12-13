package server;

import server.Repository.Repository;
import server.Repository.RepositoryImpl;

import java.util.Scanner;

public class InputProcessor {
    static Repository repo = new RepositoryImpl();

    public static void set(int index, Scanner scanner) {
        String value = scanner.nextLine();

        System.out.println(repo.set(index, value) ? "OK" : "ERROR");
    }

    public static void get(int index, Scanner scanner) {
        String value = repo.get(index);

        System.out.println(value == null ? "ERROR" : value);
    }

    public static void delete(int index, Scanner scanner) {
        System.out.println(repo.delete(index) ? "OK" : "ERROR");
    }
}
