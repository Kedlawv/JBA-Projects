package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyServer {

    private final int port;
    private ServerSocket serverSocket;
    private final ExecutorService es;
    private boolean exit = false;

    public MyServer(int port) {
        this.port = port;
        es = Executors.newFixedThreadPool(4);
    }

    public void start() {
        System.out.println("Server started!");

        try (ServerSocket server = new ServerSocket(port)) {
            serverSocket = server;
            while (true) {
                System.out.println("Waiting for incoming request");
                Socket socket = server.accept();
                es.submit(new ServerThreadWorker(socket, this));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        es.shutdown();
        try {
            boolean isShutdown = es.awaitTermination(1, TimeUnit.SECONDS);
            System.out.println("Shutdown => " + isShutdown);
            try {
                serverSocket.close();
                System.out.println("Server accept() interrupted");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
