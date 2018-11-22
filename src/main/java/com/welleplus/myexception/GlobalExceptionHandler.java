package com.welleplus.myexception;

import com.welleplus.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result myExceptionHandler(HttpServletRequest request, Exception e) throws Exception{
        e.printStackTrace();
        Result result = new Result();
        result.setStatus(false);
        result.setMessage("系统错误！");
        return result;
    }

}
