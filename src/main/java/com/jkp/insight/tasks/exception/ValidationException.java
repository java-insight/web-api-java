package com.jkp.insight.tasks.exception;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ValidationException extends  BaseException {
    private String errorMessage;
}
