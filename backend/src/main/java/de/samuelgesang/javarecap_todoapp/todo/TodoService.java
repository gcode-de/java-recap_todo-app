package de.samuelgesang.javarecap_todoapp.todo;

import de.samuelgesang.javarecap_todoapp.history.HistoryItem;
import de.samuelgesang.javarecap_todoapp.history.HistoryRepository;
import de.samuelgesang.javarecap_todoapp.history.historyAction;
import org.springframework.stereotype.Service;

import java.awt.event.HierarchyEvent;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final HistoryRepository historyRepository;

    public TodoService(TodoRepository todoRepository, HistoryRepository historyRepository) {
        this.todoRepository = todoRepository;
        this.historyRepository = historyRepository;
    }

    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<TodoItem> getTodoById(String id) {
        return todoRepository.findById(id);
    }

    public TodoItem createTodo(NewTodoItemDTO newTodoItemDTO) {
        TodoItem newTodoItem = new TodoItem(newTodoItemDTO.description(), UUID.randomUUID().toString(),newTodoItemDTO.status());
        //add to history
        historyRepository.push(new HistoryItem(historyAction.CREATE, null, newTodoItem));
        return todoRepository.save(newTodoItem);
    }

    public TodoItem updateTodo(TodoItem updatedTodoItem) {
        //add to history
        TodoItem oldTodoItem = todoRepository.findById(updatedTodoItem.id()).orElse(null);
        historyRepository.push(new HistoryItem(historyAction.UPDATE, oldTodoItem, updatedTodoItem));

        return todoRepository.save(updatedTodoItem);
    }

    public void deleteTodo(String id) {
        //add to history
        TodoItem oldTodoItem = todoRepository.findById(id).orElse(null);
        historyRepository.push(new HistoryItem(historyAction.DELETE, oldTodoItem, null));

        todoRepository.deleteById(id);
    }
}
