package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    private static final int SOCKET = 7070;

    public static void main(String[] args) {
        System.out.println("Client started!");
        try(Socket socket = new Socket(InetAddress.getLocalHost(),SOCKET);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            String msg = "Give me a record # 12";
            dos.writeUTF(msg);
            System.out.println("Sent: " + msg);
            String msgIn = dis.readUTF();
            System.out.println("Received: " + msgIn);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
