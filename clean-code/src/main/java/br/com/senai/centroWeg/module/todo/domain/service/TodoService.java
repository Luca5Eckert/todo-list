package br.com.senai.centroWeg.module.todo.domain.service;

import br.com.senai.centroWeg.module.todo.application.dto.TodoCreateRequest;
import br.com.senai.centroWeg.module.todo.application.dto.TodoUpdateRequest;
import br.com.senai.centroWeg.module.todo.domain.exception.TodoNotFoundException;
import br.com.senai.centroWeg.module.todo.domain.model.Todo;
import br.com.senai.centroWeg.module.todo.domain.query.GetTodoByIdQuery;
import br.com.senai.centroWeg.module.todo.domain.query.GetTodoByUserQuery;
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

    public Todo create (TodoCreateRequest request){

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

    public Todo findById (GetTodoByIdQuery query){
        return todoRepository.findById(query.id())
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));
    }

    public List<Todo> getAllByUserId(GetTodoByUserQuery query) {
        return todoRepository.findAllByUserId(query.userId());
    }

    public void deleteById(GetTodoByUserQuery query) {
        todoRepository.deleteById(query.userId());
    }
}
