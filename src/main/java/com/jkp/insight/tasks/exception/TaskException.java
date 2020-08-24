package com.jkp.insight.tasks.exception;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.function.Supplier;

@Value
@AllArgsConstructor
public class TaskException extends  BaseException {
    private String errorMessage;
}