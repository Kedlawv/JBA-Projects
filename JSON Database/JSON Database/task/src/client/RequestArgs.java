package client;

import com.beust.jcommander.Parameter;

public class RequestArgs {
    @Parameter(names = "-t", description = "type of request")
    private String type;

    @Parameter(names = "-k", description = "key")
    private String key;

    @Parameter(names = "-v", description = "value")
    private String value;

    @Parameter(names = "-in", description = "file name")
    private String fileName;

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getFileName() {
        return fileName;
    }
}
