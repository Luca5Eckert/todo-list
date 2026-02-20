package br.com.senai.centroWeg.infrastructure.repositories.todo;

import br.com.senai.centroWeg.module.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTodoRepository extends JpaRepository<Todo, Integer> {
}
