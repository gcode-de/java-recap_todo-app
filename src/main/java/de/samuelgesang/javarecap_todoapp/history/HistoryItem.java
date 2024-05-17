package de.samuelgesang.javarecap_todoapp.history;

import de.samuelgesang.javarecap_todoapp.todo.TodoItem;

public record HistoryItem(historyAction action, TodoItem oldData, TodoItem newData) {
}
