package br.com.senai.centroWeg.module.todo.domain.model;

import br.com.senai.centroWeg.module.todo.domain.exception.TodoAlreadyCompletedException;
import jakarta.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private int authorId;

    @Column
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

    public void changeStatus(StatusTodo status) {
        if(this.statusTodo == StatusTodo.COMPLETED){
            throw new TodoAlreadyCompletedException();
        }
        this.statusTodo = status;
    }

    public boolean isCompleted() {
        return this.statusTodo == StatusTodo.COMPLETED;
    }
}
