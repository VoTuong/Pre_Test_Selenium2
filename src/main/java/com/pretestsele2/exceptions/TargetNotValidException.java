package com.pretestsele2.exceptions;

public class TargetNotValidException extends IllegalStateException{
    public TargetNotValidException(String target) {
        super(String.format("DriverMode %s not supported. Use either local or gird", target));
    }
}
