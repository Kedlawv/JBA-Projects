package client;

import com.beust.jcommander.JCommander;

public class MessageMaker {

    public static String makeMessage(String[] args){
        ArgsDef jArgs = new ArgsDef();
        JCommander
                .newBuilder()
                .addObject(jArgs)
                .build()
                .parse(args);

        String request = jArgs.getRequest();

        StringBuilder sb = new StringBuilder();

        switch(request){
            case "get":

            case "delete":
                sb.append(request)
                        .append(" ")
                        .append(jArgs.getIndex());
                break;
            case "set":
                sb.append(request)
                        .append(" ")
                        .append(jArgs.getIndex())
                        .append(" ")
                        .append(jArgs.getMessage());
                break;
            case "exit":
                sb.append(request);
                break;
            default:
                break;
        }
        return sb.toString();
    }
}
