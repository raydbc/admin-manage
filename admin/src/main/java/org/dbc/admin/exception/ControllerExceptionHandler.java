package org.dbc.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ray,liu on 2018/9/26.
 * <p>
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
    @ExceptionHandler(RequestLimitException.class)
    //将返回的值转成json格式的数据
    @ResponseBody
    //返回的状态码
    @ResponseStatus(value= HttpStatus.TOO_MANY_REQUESTS)     //服务内部错误
    public Map<String,Object> handlerUserNotExistException(RequestLimitException ex){
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("code", ex.getId());
        result.put("message", ex.getMessage());
        return result;
    }
}
