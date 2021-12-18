package client;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;

public class MessageMaker {

    public static String makeMessage(String[] args) {
        RequestArgs jRequestArgs = new RequestArgs();
        JCommander
                .newBuilder()
                .addObject(jRequestArgs)
                .build()
                .parse(args);

        Gson gson = new Gson();

        return gson.toJson(jRequestArgs);
    }
}
