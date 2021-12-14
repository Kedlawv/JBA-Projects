package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    private static final int PORT = 7070;

    public static void main(String[] args) {
        System.out.println("Client started!");

        String msg = MessageMaker.makeMessage(args);

        try(Socket socket = new Socket(InetAddress.getLocalHost(), PORT);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            dos.writeUTF(msg);
            System.out.println("Sent: " + msg);
            String msgIn = dis.readUTF();
            System.out.println("Received: " + msgIn);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
