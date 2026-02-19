package br.com.senai.centroWeg.service;

import br.com.senai.centroWeg.domain.Todo;
import br.com.senai.centroWeg.dto.TodoCreateRequest;
import br.com.senai.centroWeg.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void create (TodoCreateRequest request){

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

    public List<Todo> list (){
        return todoRepository.findAll();
    }

    public Optional<Todo> findById (int id){
       return todoRepository.findById(id);
    }


}
