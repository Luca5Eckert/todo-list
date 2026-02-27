package br.com.senai.centroWeg.module.todo.domain.exception;

public class TodoNotFoundException extends TodoException {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
