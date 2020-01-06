package com.zsc.qc.config;

import com.zsc.qc.constant.SystemEnum;
import com.zsc.qc.utils.Result;
import com.zsc.qc.utils.CustomizeException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @ClassName ExceptionHandlerAdvice
 * @Description TODO
 * @Author zhusc
 * @Date 2020/1/6 11:19
 * @Version 1.0
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        return new Result(SystemEnum.RESP_STATUS_INTERNAL_ERROR.getCode(),e.getMessage());
    }

    //自定义异常
    @ExceptionHandler(CustomizeException.class)
    public Result handleException(CustomizeException e){
        e.printStackTrace();
        return new Result(e.getStatusCode(),e.getMessage());
    }

    //这是实体类 参数校验注解不通过会抛出的异常 只有全局异常能拦截到
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleIllegalParamException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = SystemEnum.RESP_PARAM_ERROR.getMsg();
        Integer code = SystemEnum.RESP_PARAM_ERROR.getCode();
        if (errors.size() > 0) {
            message = errors.get(0).getDefaultMessage();
        }
        Result result = new Result(code,message);
        return result;
    }


}
