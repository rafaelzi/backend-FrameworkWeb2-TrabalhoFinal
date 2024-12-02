package com.example.backend.repository;

import com.example.backend.model.Task; // Importa a classe Task que representa a entidade de tarefa
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data JPA
import org.springframework.stereotype.Repository; // Anotação para indicar que esta interface é um repositório

@Repository // Indica que esta interface é um repositório Spring
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Estende JpaRepository, especificando a entidade (Task) e o tipo da chave primária (Long)
}
