package server.Repository;

import server.DB;

public class RepositoryImpl implements Repository {

    private final DB db = DB.getInstance();

    @Override
    public boolean set(String key, String value) {
        db.records.put(key, value);
        return true;
    }

    @Override
    public String get(String key) {
        return db.records.get(key);
    }

    @Override
    public String delete(String key) {
        return db.records.remove(key);

    }

}
