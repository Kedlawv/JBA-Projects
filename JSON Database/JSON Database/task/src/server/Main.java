package server;

public class Main {

    public static void main(String[] args) {

        MyServer server = new MyServer(7070);
        server.start();
    }
}
