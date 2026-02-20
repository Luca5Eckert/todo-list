package br.com.senai.centroWeg.module.todo.domain.service;

import br.com.senai.centroWeg.module.todo.application.dto.TodoUpdateRequest;
import br.com.senai.centroWeg.module.todo.domain.model.Todo;
import br.com.senai.centroWeg.module.todo.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create (TodoUpdateRequest request){

        //Valida se o titulo é unico
        if(todoRepository.existsByTitle(request.title())){
            throw new RuntimeException("Já exite um item com este titulo");
        }

        //Converte o request em entidade
        Todo todo = new Todo(
                request.title(),
                request.Description(),
                request.authorId(),
                request.statusTodo()
        );

        todoRepository.save(todo);
        return todo;
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
