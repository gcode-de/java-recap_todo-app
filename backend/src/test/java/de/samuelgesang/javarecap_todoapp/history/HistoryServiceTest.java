package de.samuelgesang.javarecap_todoapp.history;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryServiceTest {

    @Test
    //GIVEN
    //Mocks einrichten
    //wenn historyRepo.pop -> historyItem per create
    //doNothing historyRepo.redo
    //doNothing todoService.delete usw


    //WHEN
    //methode aufrufen (historyService.undo)


    //THEN
    //verify pop
    //verify redoStack
    //verify todoService

    //Tests für alle Methoden

    //Tests, was passiert, wenn undo fehlschlägt, weil Daten manuell geändert wurden

}

//=========
//INTEGRATION
//Testdatenbank mit flapdoodle
//GIVEN
//Mit Mockmvc Todo über post-endpunkt erstellen

//WHEN
//Undo -Endpunkt aufrufen

//THEN
//Get-Req um das Todo zu überprüfen


//Integration für andere Szenarien (delete etc)