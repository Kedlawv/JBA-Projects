package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    private final int port;

    public MyServer(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Server started!");

        while (true) {
            try (ServerSocket server = new ServerSocket(port);
                 Socket socket = server.accept();
                 DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                 DataInputStream dis = new DataInputStream(socket.getInputStream())) {

                String msgIn = dis.readUTF();
                RequestHandler rh = new RequestHandler();
                String msgOut = rh.handleRequest(msgIn);

                dos.writeUTF(msgOut);
                System.out.println("Sent: " + msgOut);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
