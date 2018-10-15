package org.dbc.admin.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LoginUserNotExistException extends RuntimeException {
    private static final long serialVersionUID = 3389857462571862367L;

    private String userName;

    private String message;

    public LoginUserNotExistException(String userName) {
        super();
        this.userName = userName;
    }

    public LoginUserNotExistException(String userName, String message) {
        super();
        this.userName = userName;
        this.message = message;
    }

}
