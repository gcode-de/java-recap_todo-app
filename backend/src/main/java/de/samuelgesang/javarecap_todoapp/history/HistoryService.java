package de.samuelgesang.javarecap_todoapp.history;

import de.samuelgesang.javarecap_todoapp.todo.NewTodoItemDTO;
import de.samuelgesang.javarecap_todoapp.todo.TodoService;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final TodoService todoService;

    public HistoryService(HistoryRepository historyRepository, TodoService todoService) {
        this.historyRepository = historyRepository;
        this.todoService = todoService;
    }

    public void addHistoryItem(HistoryItem historyItem) {
        historyRepository.push(historyItem);
        System.out.println(historyItem);
    }

    public void historyUndo(){
//TODO: Änderung zurück geben?

        HistoryItem actionToUndo = historyRepository.pop();

        historyRepository.pushToRedoStack(actionToUndo);

        //revert chnages in TodoRepo according to actionToUndo
        switch (actionToUndo.action()){
            case historyAction.CREATE:
                todoService.deleteTodo(actionToUndo.newData().id());
                break;

            case historyAction.DELETE:
                todoService.createTodo(new NewTodoItemDTO(actionToUndo.oldData().description(), actionToUndo.oldData().status()));
                break;

            case historyAction.UPDATE:
                todoService.updateTodo(actionToUndo.oldData());
        }

    }

    public void historyRedo(){
//TODO
    }
}
