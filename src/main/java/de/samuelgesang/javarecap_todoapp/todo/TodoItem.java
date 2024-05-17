package de.samuelgesang.javarecap_todoapp.todo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("todos")
public record TodoItem(String description, String id, todoStatus status) {
}
