package org.dbc.admin.exception;

/**
 * @author shijie 2018/5/4
 */
public class DataExistException extends RuntimeException {

    private String id;

    private String message;

    public DataExistException(String id) {
        super();
        this.id = id;
    }

    public DataExistException(String id, String message) {
        super();
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
