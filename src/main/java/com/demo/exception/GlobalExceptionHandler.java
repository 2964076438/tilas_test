package com.demo.exception;

import com.demo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    //TODO: global exception handler
    @ExceptionHandler
    public Result ExceptionHandler(Exception e){
        log.error("Exception: {}", e.getMessage());

        return Result.error(e.getMessage());
    }
    @ExceptionHandler
    public Result DuplicateKeyExceptionHandler(DuplicateKeyException e){
        log.error("Exception: {}", e.getMessage());
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String substring = message.substring(i);
        String[] split = substring.split(" ");
        String s = split[2];
        return Result.error(s+"已存在");
    }
}
