package com.zorvyn.dhananjay.exception;

public class OAuth2AuthenticationException extends RuntimeException {
    public OAuth2AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
