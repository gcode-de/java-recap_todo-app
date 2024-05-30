package de.samuelgesang.javarecap_todoapp.history;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HistoryRepository {

    private List<HistoryItem> historyStack;
    private List<HistoryItem> redoStack;

    public void push(HistoryItem historyItem) {
        if (historyStack == null) {
            historyStack = new ArrayList<>();
        }
        historyStack.add(historyItem);
    }

    public HistoryItem pop() {
        if (historyStack == null) {
            return null;
        }
        return historyStack.removeLast();
    }


    public void pushToRedoStack(HistoryItem historyItem) {
        if (redoStack == null) {
            redoStack = new ArrayList<>();
        }
        redoStack.add(historyItem);
    }

    public HistoryItem popFromRedoStack() {
        if (redoStack == null) {
            return null;
        }
        return redoStack.removeLast();
    }
}
