package br.com.senai.centroWeg.infrastructure.repositories.todo;

import br.com.senai.centroWeg.module.todo.domain.model.Todo;
import br.com.senai.centroWeg.module.todo.domain.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepositoryAdapter implements TodoRepository {

    private final JpaTodoRepository jpaTodoRepository;

    public TodoRepositoryAdapter(JpaTodoRepository jpaTodoRepository) {
        this.jpaTodoRepository = jpaTodoRepository;
    }

    @Override
    public Todo save(Todo todo) {
        return jpaTodoRepository.save(todo);
    }

    @Override
    public List<Todo> findAll() {
        return jpaTodoRepository.findAll();
    }

    @Override
    public Optional<Todo> findById(int id) {
        return jpaTodoRepository.findById(id);
    }

    @Override
    public boolean existsByTitle(String title) {
        return jpaTodoRepository.existsByTitle(title);
    }

    @Override
    public List<Todo> findAllByUserId(int userId) {
        return jpaTodoRepository.findAllByAuthorId(userId);
    }

    @Override
    public void deleteById(int id) {
        jpaTodoRepository.deleteById(id);
    }
}
