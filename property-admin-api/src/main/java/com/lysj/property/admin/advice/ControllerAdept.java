package com.lysj.property.admin.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author fupeng
 * @date 2019/1/29
 */
@ControllerAdvice
@Slf4j
public class ControllerAdept {

    @ExceptionHandler(Exception.class)
    @ResponseStatus
    public Object exceptionHandler(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return ResponseEntity.badRequest();
    }

}
