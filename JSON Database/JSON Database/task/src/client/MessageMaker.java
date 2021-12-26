package client;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class MessageMaker {

    public static String makeMessage(String[] args) {
        RequestArgs jRequestArgs = new RequestArgs();
        Gson gson = new Gson();
        String requestMessage;

        JCommander
                .newBuilder()
                .addObject(jRequestArgs)
                .build()
                .parse(args);

        if (jRequestArgs.getFileName() != null) {
            requestMessage = getRequestFromFile(jRequestArgs.getFileName());
        } else {
            requestMessage = gson.toJson(jRequestArgs);
        }
        return requestMessage;
    }

    private static String getRequestFromFile(String fileName) {
        Path path = Path.of("JSON Database\\task\\src\\client\\data\\" + fileName);
        try (BufferedReader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
