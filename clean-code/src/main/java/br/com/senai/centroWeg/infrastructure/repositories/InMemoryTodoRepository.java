package br.com.senai.centroWeg.infrastructure.repositories;

import br.com.senai.centroWeg.module.todo.model.Todo;
import br.com.senai.centroWeg.module.todo.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryTodoRepository implements TodoRepository {

    @Override
    public Todo save(Todo todo) {
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return List.of();
    }

    @Override
    public Optional<Todo> findById(int Id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByTitle(String title) {
        return false;
    }
}
