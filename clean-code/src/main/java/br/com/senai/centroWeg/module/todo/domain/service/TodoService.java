package br.com.senai.centroWeg.module.todo.domain.service;

import br.com.senai.centroWeg.module.todo.domain.model.Todo;
import br.com.senai.centroWeg.module.todo.application.dto.TodoUpdateRequest;
import br.com.senai.centroWeg.module.todo.domain.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void create (TodoUpdateRequest request){
        if(todoRepository.existsByTitle(request.title())){
            throw new RuntimeException("Já exite um item com este titulo");
        }

        Todo todo = new Todo(
                request.title(),
                request.Description(),
                request.authorId(),
                request.statusTodo()
        );

        todoRepository.save(todo);
    }

    public void update(int todoId, TodoUpdateRequest request){

    }


    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public Optional<Todo> findById (int id){
       return todoRepository.findById(id);
    }


}
