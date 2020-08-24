package com.jkp.insight.tasks.controller.fault;

import com.jkp.insight.tasks.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TaskFaultHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    TaskFault exceptionHandler(BaseException e){
        return new TaskFault(HttpStatus.BAD_REQUEST.value(), e.getErrorMessage());
    }
}
