package com.example.backend.controller;

import com.example.backend.model.Task; // Importa a classe Task que representa a entidade de tarefa
import com.example.backend.repository.TaskRepository; // Importa a interface TaskRepository para acessar o banco de dados
import org.springframework.beans.factory.annotation.Autowired; // Injeta a dependência do TaskRepository
import org.springframework.http.ResponseEntity; // Usado para construir respostas HTTP
import org.springframework.web.bind.annotation.*; // Importa anotações para definir endpoints REST

import java.util.List; // Usado para retornar listas de tarefas
import java.util.Optional; // Usado para lidar com a possibilidade de uma tarefa não ser encontrada

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/tasks") // Define o prefixo da URL para todos os endpoints deste controlador
public class TaskController {

    @Autowired // Injeta uma instância do TaskRepository
    private TaskRepository taskRepository;

    // Endpoint para listar todas as tarefas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll(); // Retorna uma lista de todas as tarefas do banco de dados
    }

    // Endpoint para buscar uma tarefa pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) { // @PathVariable extrai o ID da URL
        Optional<Task> task = taskRepository.findById(id); // Busca a tarefa pelo ID
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); // Retorna a tarefa se encontrada, ou erro 404 se não
    }

    // Endpoint para criar uma nova tarefa
    @PostMapping
    public Task createTask(@RequestBody Task task) { // @RequestBody desserializa o JSON da requisição para um objeto Task
        return taskRepository.save(task); // Salva a nova tarefa no banco de dados
    }

    // Endpoint para atualizar uma tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id); // Busca a tarefa pelo ID
        if (optionalTask.isPresent()) { // Verifica se a tarefa existe
            Task task = optionalTask.get(); // Obtém a tarefa do Optional
            task.setName(taskDetails.getName()); // Atualiza o nome da tarefa
            task.setDescription(taskDetails.getDescription()); // Atualiza a descrição da tarefa
            task.setDueDate(taskDetails.getDueDate()); // Atualiza a data limite da tarefa
            return ResponseEntity.ok(taskRepository.save(task)); // Salva a tarefa atualizada e retorna 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se a tarefa não existir
        }
    }

    // Endpoint para excluir uma tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskRepository.existsById(id)) { // Verifica se a tarefa existe
            taskRepository.deleteById(id); // Exclui a tarefa do banco de dados
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se a tarefa não existir
        }
    }
}
