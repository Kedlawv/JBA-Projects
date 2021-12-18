package server;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DB {

    private static DB instance;
    public final Map<String, String> records = new HashMap<>();

    private DB() {
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }
}
