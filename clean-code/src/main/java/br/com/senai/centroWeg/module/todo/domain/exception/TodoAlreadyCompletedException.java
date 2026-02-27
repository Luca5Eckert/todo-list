package br.com.senai.centroWeg.module.todo.domain.exception;

public class TodoAlreadyCompletedException extends TodoException {
    public TodoAlreadyCompletedException(String message) {
        super(message);
    }

    public TodoAlreadyCompletedException() {
        super("Todo already completed");
    }
}
