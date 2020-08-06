package com.hunter.cursomc.services.exceptions;

public class MethodArgumentNotValidException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public MethodArgumentNotValidException(String msg) {
        super(msg);
    }

    public MethodArgumentNotValidException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
