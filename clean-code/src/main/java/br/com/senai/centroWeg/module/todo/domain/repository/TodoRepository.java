package br.com.senai.centroWeg.module.todo.domain.repository;

import br.com.senai.centroWeg.module.todo.domain.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    public Todo save(Todo todo);
    public List<Todo> findAll();
    public Optional<Todo> findById(int Id);

    public boolean existsByTitle(String title);

}
