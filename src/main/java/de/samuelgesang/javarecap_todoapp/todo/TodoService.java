package de.samuelgesang.javarecap_todoapp.todo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<TodoItem> getTodoById(String id) {
        return todoRepository.findById(id);
    }

    public TodoItem createTodo(NewTodoItemDTO newTodoItemDTO) {
        TodoItem newTodoItem = new TodoItem(newTodoItemDTO.description(), UUID.randomUUID().toString(),newTodoItemDTO.status());
        //TODO: add to history
        return todoRepository.save(newTodoItem);
    }

    public TodoItem updateTodo(TodoItem updatedTodoItem) {
        //TODO: add to history
        return todoRepository.save(updatedTodoItem);
    }

    public void deleteTodo(String id) {
        //TODO: add to history
        todoRepository.deleteById(id);
    }
}
