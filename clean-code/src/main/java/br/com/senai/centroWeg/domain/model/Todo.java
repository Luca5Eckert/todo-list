package br.com.senai.centroWeg.domain.model;

public class Todo {

    private final int id;

    private String title;

    private String description;

    private StatusTodo statusTodo;

    public Todo(int id, String title, String description, StatusTodo statusTodo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.statusTodo = statusTodo;
    }

    public StatusTodo getStatusTodo() {
        return statusTodo;
    }

    public void setStatusTodo(StatusTodo statusTodo) {
        this.statusTodo = statusTodo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

}
