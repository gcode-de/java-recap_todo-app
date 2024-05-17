package de.samuelgesang.javarecap_todoapp.todo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class TodoRepository {
    private List<TodoItem> todos;
}
