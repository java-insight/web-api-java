package com.jkp.insight.tasks.exception;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class TaskException extends  BaseException {
    private String errorMessage;
}