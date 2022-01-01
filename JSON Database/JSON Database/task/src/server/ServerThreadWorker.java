package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThreadWorker extends Thread {

    private final Socket socket;
    private final MyServer server;

    public ServerThreadWorker(Socket socket, MyServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            String msgIn = dis.readUTF();
            RequestHandler rh = new RequestHandler();
            String msgOut = rh.handleRequest(msgIn, server);

            dos.writeUTF(msgOut);
            System.out.println("Sent: " + msgOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }
}
