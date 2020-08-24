package com.jkp.insight.tasks.exception;

import java.util.function.Supplier;

public abstract class  BaseException
        extends RuntimeException
        implements Supplier<BaseException> {

    public abstract String getErrorMessage();
    public BaseException get() {
        return this;
    }
}
