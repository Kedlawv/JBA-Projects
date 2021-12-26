package server.Repository;

import server.data.DB;

import java.util.Map;

public class RepositoryImpl implements Repository {

    private final DB db = DB.getInstance();

    @Override
    public boolean set(String key, String value) {
        Map<String, String> records = db.getRecords();
        records.put(key, value);
        return db.setRecords(records);
    }

    @Override
    public String get(String key) {
        return db.getRecords().get(key);
    }

    @Override
    public String delete(String key) {
        Map<String, String> records = db.getRecords();
        String deletedItem = records.remove(key);
        db.setRecords(records);
        return deletedItem;


    }

}
