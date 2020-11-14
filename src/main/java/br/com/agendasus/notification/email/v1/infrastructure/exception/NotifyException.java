package br.com.agendasus.notification.email.v1.infrastructure.exception;

public class NotifyException extends RuntimeException {

    public NotifyException(String message) {
        super(message);
    }

}