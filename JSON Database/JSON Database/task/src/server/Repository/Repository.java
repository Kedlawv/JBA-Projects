package server.Repository;

public interface Repository {
    boolean set(int index, String value);
    String get(int index);
    boolean delete(int index);
}
