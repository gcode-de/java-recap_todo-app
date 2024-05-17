package de.samuelgesang.javarecap_todoapp.history;

import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public void addHistoryItem(HistoryItem historyItem) {
        historyRepository.push(historyItem);
    }

    public void historyUndo(){
//TODO
    }

    public void historyRedo(){
//TODO
    }
}
