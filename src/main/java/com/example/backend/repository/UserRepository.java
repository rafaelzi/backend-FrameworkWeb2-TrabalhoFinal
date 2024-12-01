package com.example.backend.repository;
 
/*
Esta interface define um repositório para a entidade User, estendendo JpaRepository. 
Isso fornece automaticamente métodos para realizar operações CRUD (Create, Read, Update, Delete) 
no banco de dados para a entidade User.
*/
 
import com.example.backend.model.User; // Importa a classe User que representa a entidade de usuário
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data JPA
import org.springframework.stereotype.Repository; // Anotação para indicar que esta interface é um repositório
 
@Repository // Indica que esta interface é um repositório Spring
public interface UserRepository extends JpaRepository<User, Long> {
    // Estende JpaRepository, especificando a entidade (User) e o tipo da chave primária (Long)
}