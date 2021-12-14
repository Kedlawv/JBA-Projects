package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Stage2MainServer {

    private static final int PORT = 7070;

    private void justForReference() {

        System.out.println("Server started!");

        try (ServerSocket server = new ServerSocket(PORT);
             Socket socket = server.accept();
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            String msgIn = dis.readUTF();
            System.out.println("Received: " + msgIn);
            String msgOut = "A record # 12 was sent!";
            dos.writeUTF(msgOut);
            System.out.println("Sent: " + msgOut);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
