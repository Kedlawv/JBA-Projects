package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThreadWorker extends Thread {

    Socket socket;

    public ServerThreadWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
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
