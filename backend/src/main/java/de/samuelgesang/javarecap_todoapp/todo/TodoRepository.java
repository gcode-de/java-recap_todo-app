package de.samuelgesang.javarecap_todoapp.todo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoItem, String> {
}
