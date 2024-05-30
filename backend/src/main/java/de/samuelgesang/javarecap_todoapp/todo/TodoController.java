package de.samuelgesang.javarecap_todoapp.todo;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoItem> getTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("{id}")
    public Optional<TodoItem> getTodoById(@PathVariable String id){
        return todoService.getTodoById(id);
    }

    @PostMapping
    public TodoItem addTodo(@RequestBody NewTodoItemDTO todoItem) {
        return todoService.createTodo(todoItem);
    }

    @PutMapping("{id}")
    public TodoItem addTodo(@PathVariable String id, @RequestBody TodoItem todoItem) {
        return todoService.updateTodo(todoItem);
    }

    @DeleteMapping("{id}")
    public void addTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
    }
}
