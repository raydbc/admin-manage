package org.dbc.admin.exception;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/10 17:53
 */
public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}