package br.com.senai.centroWeg.infrastructure.repositories.todo;

import br.com.senai.centroWeg.module.todo.model.Todo;
import br.com.senai.centroWeg.module.todo.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepositoryAdapter implements TodoRepository {

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
