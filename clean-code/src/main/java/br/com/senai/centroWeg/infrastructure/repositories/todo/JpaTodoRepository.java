package br.com.senai.centroWeg.infrastructure.repositories.todo;

import br.com.senai.centroWeg.module.todo.domain.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTodoRepository extends JpaRepository<Todo, Integer> {
    
    boolean existsByTitle(String title);
    
    List<Todo> findAllByAuthorId(int authorId);
}
