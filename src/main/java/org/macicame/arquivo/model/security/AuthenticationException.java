package org.macicame.arquivo.model.security;

/**
 * Created by acacio on 15/03/19.
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
