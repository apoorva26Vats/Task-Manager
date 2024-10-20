package net.javaguide.Task_Manager.controller;


import net.javaguide.Task_Manager.dto.CreateNoteDTO;
import net.javaguide.Task_Manager.dto.CreateNoteResponseDTO;
import net.javaguide.Task_Manager.entities.NoteEntity;
import net.javaguide.Task_Manager.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Notes")
public class NotesController {

    private final NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/getAllNotes")
    public ResponseEntity<List<NoteEntity>> getAllNotes() {
        List<NoteEntity> allNotes = noteService.getAllNotes();

        if (!allNotes.isEmpty()) {
            return ResponseEntity.ok(allNotes);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/getsNots/{taskId}")
    public ResponseEntity<List<NoteEntity>> getsNots(@PathVariable("taskId") Integer taskId) {
        List<NoteEntity> notes = noteService.getNotesForTask(taskId);

        if (notes == null || notes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notes);
    }

    @PostMapping("/addNote/{taskId}")
    public ResponseEntity<CreateNoteResponseDTO> addNote(@PathVariable("taskId") Integer taskId,
                                                         @RequestBody CreateNoteDTO note) {
        NoteEntity newNote = noteService.addNoteForTask(
                taskId,
                note.getTitle(),
                note.getBody()
        );
        if (newNote != null) {
            return ResponseEntity.ok(new CreateNoteResponseDTO(taskId, newNote));
        }
        return ResponseEntity.notFound().build();

    }

}
