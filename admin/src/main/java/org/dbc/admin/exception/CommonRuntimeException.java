package org.dbc.admin.exception;

/**
 * @author shijie 2018/7/25
 */
public class CommonRuntimeException extends RuntimeException {

    private String id;

    private String message;

    public CommonRuntimeException(String id) {
        super();
        this.id = id;
    }

    public CommonRuntimeException(String id, String message) {
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
