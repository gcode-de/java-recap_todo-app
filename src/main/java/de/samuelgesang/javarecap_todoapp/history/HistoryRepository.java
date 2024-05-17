package de.samuelgesang.javarecap_todoapp.history;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HistoryRepository {

    private List<HistoryItem> historyStack;

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
}
