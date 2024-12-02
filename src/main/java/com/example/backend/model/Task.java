package com.example.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate; // Importa o tipo LocalDate para datas

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único da tarefa

    @Column(nullable = false) // Nome da tarefa, obrigatório
    private String name;

    @Column(length = 500) // Descrição da tarefa, com limite opcional de 500 caracteres
    private String description;

    @Column(nullable = false) // Data limite da tarefa, obrigatória
    private LocalDate dueDate;

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
