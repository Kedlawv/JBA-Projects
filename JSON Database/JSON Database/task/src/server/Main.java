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

        boolean exit = false;

        while (!exit) {
            try (ServerSocket server = new ServerSocket(PORT);
                 Socket socket = server.accept();
                 DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                 DataInputStream dis = new DataInputStream(socket.getInputStream())) {

                String msgIn = dis.readUTF();
                Scanner scanner = new Scanner(msgIn);

                String msgOut = null;
                String command = null;

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
                        msgOut = InputProcessor.get(index);
                        break;
                    case "set":
                        msgOut = InputProcessor.set(index, scanner.nextLine());
                        break;
                    case "delete":
                        msgOut = InputProcessor.delete(index);
                        break;
                    case "exit":
                        exit = true;
                        msgOut = "OK";
                        break;
                    default:
                        System.out.println("Command does not exist => " + command);
                }

                dos.writeUTF(msgOut);
                System.out.println("Sent: " + msgOut);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
