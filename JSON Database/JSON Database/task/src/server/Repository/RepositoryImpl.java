package server.Repository;

import server.data.DB;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RepositoryImpl implements Repository {

    private final DB db = DB.getInstance();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writeLock = lock.writeLock();
    private final Lock readLock = lock.readLock();

    @Override
    public boolean set(String key, String value) {
        try {
            writeLock.lock();
            Map<String, String> records = db.getRecords();
            records.put(key, value);
            return db.setRecords(records);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public String get(String key) {
        try {
            readLock.lock();
            return db.getRecords().get(key);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public String delete(String key) {
        try {
            writeLock.lock();
            Map<String, String> records = db.getRecords();
            String deletedItem = records.remove(key);
            db.setRecords(records);
            return deletedItem;
        } finally {
            writeLock.unlock();
        }


    }

}
