package br.com.senai.centroWeg.module.todo.model;

public class Todo {

    private int id;

    private String title;

    private String description;

    private int authorId;

    private StatusTodo statusTodo;

    public Todo(String title, String description, int authorId, StatusTodo statusTodo) {
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.statusTodo = statusTodo;
    }

    public Todo(int id, String title, String description, int authorId, StatusTodo statusTodo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.statusTodo = statusTodo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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
