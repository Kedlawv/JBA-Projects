package server;

import java.util.Arrays;

public class DB {

    private static DB instance;
    public final String[] records = new String[100];

    private DB() {
        init();
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    private void init() {
        Arrays.fill(records, "");
    }
}
