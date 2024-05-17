package de.samuelgesang.javarecap_todoapp.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private List<TodoItem> todos = new ArrayList<>();

    public TodoController() {
        todos.add(new TodoItem("DefaultTest", "test-id", todoStatus.OPEN));
    }

    @GetMapping
    public List<TodoItem> getTodos(){
        return todos;
    }

    @PostMapping
    public TodoItem addTodo(@RequestBody TodoItem todoItem) {
        todos.add(todoItem);
        return todoItem;
    }
}
