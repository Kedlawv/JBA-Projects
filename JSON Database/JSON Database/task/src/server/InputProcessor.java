package server;

import server.Repository.Repository;
import server.Repository.RepositoryImpl;

public class InputProcessor {
    static Repository repo = new RepositoryImpl();

    public static String set(int index, String value) {
        return repo.set(index, value) ? "OK" : "ERROR";
    }

    public static String get(int index) {
        String value = repo.get(index);

        return value == null ? "ERROR" : value;
    }

    public static String delete(int index) {
        return repo.delete(index) ? "OK" : "ERROR";
    }
}
