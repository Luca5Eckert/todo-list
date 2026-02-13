package br.com.senai.centroWeg.service;

import br.com.senai.centroWeg.domain.Todo;
import br.com.senai.centroWeg.repository.TodoRepository;

public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void newTodoItem (Todo todo){


    }


}
