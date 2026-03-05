package br.com.senai.centroWeg.module.todo.domain.service;

import br.com.senai.centroWeg.module.todo.domain.command.TodoCreateCommand;
import br.com.senai.centroWeg.module.todo.domain.command.UpdateTodoCommand;
import br.com.senai.centroWeg.module.todo.domain.exception.TodoException;
import br.com.senai.centroWeg.module.todo.domain.exception.TodoNotFoundException;
import br.com.senai.centroWeg.module.todo.domain.model.Todo;
import br.com.senai.centroWeg.module.todo.domain.port.StreakUpdater;
import br.com.senai.centroWeg.module.todo.domain.query.GetTodoByIdQuery;
import br.com.senai.centroWeg.module.todo.domain.query.GetTodoByUserQuery;
import br.com.senai.centroWeg.module.todo.domain.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final StreakUpdater streakUpdater;

    public TodoService(TodoRepository todoRepository, StreakUpdater streakUpdater) {
        this.todoRepository = todoRepository;
        this.streakUpdater = streakUpdater;
    }

    public Todo create (TodoCreateCommand command){

        if(todoRepository.existsByTitle(command.title())){
            throw new TodoException("Already exists a todo with this title");
        }

        Todo todo = new Todo(
                command.title(),
                command.description(),
                command.authorId(),
                command.statusTodo()
        );

        todoRepository.save(todo);
        return todo;
    }

    public void update(UpdateTodoCommand command){
        Todo todo = todoRepository.findById(command.todoId())
                .orElseThrow(() -> new TodoException("Todo not found"));

        todo.changeStatus(command.status());
        todoRepository.save(todo);

        if (todo.isCompleted()) streakUpdater.update(command.userId());;
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

    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }
}
