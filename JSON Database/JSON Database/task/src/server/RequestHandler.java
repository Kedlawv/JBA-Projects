package server;

import client.RequestArgs;
import com.google.gson.Gson;
import server.Repository.Repository;
import server.Repository.RepositoryImpl;

public class RequestHandler {

    Repository repo = new RepositoryImpl();

    public String handleRequest(String msgIn) {
        Gson gson = new Gson();
        RequestArgs requestArgs = gson.fromJson(msgIn, RequestArgs.class);
        ResponseArgs responseArgs = new ResponseArgs();

        String command = requestArgs.getType();
        String key = requestArgs.getKey();

        switch (command) {
            case "get":
                String value = repo.get(key);
                if (value != null) {
                    responseArgs.setResponse("OK");
                    responseArgs.setValue(value);
                } else {
                    responseArgs.setResponse("ERROR");
                    responseArgs.setReason("No such key");
                }
                break;
            case "set":
                if (repo.set(key, requestArgs.getValue())) {
                    responseArgs.setResponse("OK");
                } else {
                    responseArgs.setResponse("ERROR");
                    responseArgs.setReason("Insertion unsuccessful");
                }
                break;
            case "delete":
                if (repo.delete(key) != null) {
                    responseArgs.setResponse("OK");
                } else {
                    responseArgs.setResponse("ERROR");
                    responseArgs.setReason("No such key");
                }
                break;
            case "exit":
                System.exit(130);
                break;
            default:
                System.out.println("Command does not exist => " + command);
        }

        return gson.toJson(responseArgs);
    }
}
