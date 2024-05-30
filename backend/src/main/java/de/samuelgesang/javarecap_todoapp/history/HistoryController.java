package de.samuelgesang.javarecap_todoapp.history;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }


    @GetMapping("/undo")
    public ResponseEntity<Object> undo(){
        historyService.historyUndo();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/redo")
    public ResponseEntity<Object> redo(){
        historyService.historyRedo();
        return ResponseEntity.ok().build();
    }

}

