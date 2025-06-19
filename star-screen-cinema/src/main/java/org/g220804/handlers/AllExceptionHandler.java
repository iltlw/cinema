package org.g220804.handlers;

import org.g220804.http.HttpCode;
import org.g220804.util.ResponseJson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AllExceptionHandler
{
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseJson exceptionHandler(Exception e)
    {
        e.printStackTrace(System.err);
        return ResponseJson.getInstance(HttpCode.SYSTEMERROR, null);
    }
}
