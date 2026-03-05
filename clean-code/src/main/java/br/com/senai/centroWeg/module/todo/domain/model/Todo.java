package br.com.senai.centroWeg.module.todo.domain.model;

import br.com.senai.centroWeg.module.todo.domain.exception.TodoAlreadyCompletedException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "todos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private int authorId;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusTodo statusTodo;

    public Todo(String title, String description, int authorId, StatusTodo statusTodo) {
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.statusTodo = statusTodo;
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
