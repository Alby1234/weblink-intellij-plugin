package com.github.alby1234.weblinkintellijplugin.exceptions;

/**
 * Exception that occurs when an unexpected response is received while calling
 * a repository api
 */
public class UnexpectedRepositoryResponseException extends Exception {

    public UnexpectedRepositoryResponseException(String message) {
        super(message);
    }
}
