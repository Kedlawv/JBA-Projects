package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static final int PORT = 7070;

    public static void main(String[] args) {
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

        /*
        String command = null;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            int index = 0;

            try {
                command = scanner.next();
                if (!"exit".equals(command)) {
                    index = scanner.nextInt() - 1;
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getClass() + " BAD INPUT!!!!!");
                continue;
            }

            switch (command) {
                case "get":
                    InputProcessor.get(index, scanner);
                    break;
                case "set":
                    InputProcessor.set(index, scanner);
                    break;
                case "delete":
                    InputProcessor.delete(index, scanner);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Command does not exist => " + command);
            }
        }

         */
    }
}
