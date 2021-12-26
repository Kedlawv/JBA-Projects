package server.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class DB {

    private static DB instance;
    public final Map<String, String> records = new HashMap<>();
    private File file;
    private final String path = "JSON Database\\task\\src\\server\\data\\db.json";
    Gson gson = new Gson();

    private DB() {
        initFile();
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public Map<String, String> getRecords() {
        if (isFileEmpty()) {
            return new HashMap<String, String>();
        }
        try (Reader reader = Files.newBufferedReader(file.toPath(),
                StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, new TypeToken<Map<String, String>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No such file: " + file);
        }
        return null;
    }

    public boolean setRecords(Map<String, String> records) {
        String jsonRecords = gson.toJson(records);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(jsonRecords);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No such file: " + file);
            return false;
        }
    }

    private void initFile() {
        try {
            file = new File(path);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isFileEmpty() {
        return file.length() == 0;
    }
}
