package org.dbc.admin.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by ray,liu on 2018/9/25.
 * <p>
 */
public class RequestLimitException extends RuntimeException {
    private static final long serialVersionUID = 1364225358754654702L;
    private String id;
    private String message;

    public RequestLimitException(){
        super("HTTP请求超出设定的限制");
    }

    public RequestLimitException(String id,String message){
        super(message);
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
