package server.Repository;

public interface Repository {
    boolean set(String key, String value);

    String get(String key);

    String delete(String key);
}
