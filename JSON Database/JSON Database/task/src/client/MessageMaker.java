package client;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MessageMaker {

    public static List<String> getMessages(String[] args) {
        RequestArgs jRequestArgs = new RequestArgs();
        Gson gson = new Gson();
        List<String> requestMessages = new ArrayList<>();

        JCommander
                .newBuilder()
                .addObject(jRequestArgs)
                .build()
                .parse(args);

        if (jRequestArgs.getFileName() != null) {
            requestMessages = getRequestsFromFile(jRequestArgs.getFileName());
        } else {
            requestMessages.add(gson.toJson(jRequestArgs));
        }
        return requestMessages;
    }

    private static List<String> getRequestsFromFile(String fileName) {
        Path path = Path.of("JSON Database\\task\\src\\client\\data\\" + fileName);
        List<String> requestMessages = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {
            reader.lines().forEach(requestMessages::add);
            return requestMessages;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
