package client;

import com.beust.jcommander.Parameter;

public class ArgsDef {
    @Parameter(names="-t", description = "type of request")
    private String request;

    @Parameter(names = "-i", description = "index")
    private int index;

    @Parameter(names = "-m", description = "message for set request")
    private String message;

    public String getRequest(){
        return request;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }
}
