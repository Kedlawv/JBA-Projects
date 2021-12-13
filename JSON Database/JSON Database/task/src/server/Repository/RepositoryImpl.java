package server.Repository;

import server.DB;

public class RepositoryImpl implements Repository {

    private final DB db = DB.getInstance();

    @Override
    public boolean set(int index, String value) {
        if (!isValidIndex(index)) {
            return false;
        }

        db.records[index] = value;
        return true;
    }

    @Override
    public String get(int index) {
        if (!isValidIndex(index)) {
            return null;
        }

        return db.records[index].isEmpty() ? null : db.records[index];
    }

    @Override
    public boolean delete(int index) {
        if (!isValidIndex(index)) {
            return false;
        }
        db.records[index] = "";
        return true;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= 99;
    }
}
