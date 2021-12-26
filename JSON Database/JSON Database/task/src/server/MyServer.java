package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {

    private final int port;
    ExecutorService es;

    public MyServer(int port) {
        this.port = port;
        es = Executors.newFixedThreadPool(4);
    }

    public void start() {
        System.out.println("Server started!");

        try (ServerSocket server = new ServerSocket(port)) {
            server.setReuseAddress(true);
            while (true) {

                Socket socket = server.accept();
                es.submit(new ServerThreadWorker(socket));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
