package net.javaguide.Task_Manager.controller;


import net.javaguide.Task_Manager.dto.CreateTaskDTO;
import net.javaguide.Task_Manager.dto.ErrorResponseDTO;
import net.javaguide.Task_Manager.dto.UpdateTaskDTO;
import net.javaguide.Task_Manager.entities.NoteEntity;
import net.javaguide.Task_Manager.entities.TaskEntity;
import net.javaguide.Task_Manager.service.TaskService;
import net.javaguide.Task_Manager.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Tasks")
public class TasksController {

    private final TaskService taskService;
    private final NoteService noteService;

//    public TasksController(TaskService taskService ) {
//        this.taskService = taskService;
//    }
    public TasksController(TaskService taskService,NoteService noteService ) {
        this.taskService = taskService;
        this.noteService = noteService;
    }


    @GetMapping("/getAllTasks")
    public ResponseEntity< ArrayList<TaskEntity> > getTasks() {
        ArrayList<TaskEntity> tasks = taskService.getTasks();
        if (!tasks.isEmpty()) {
            return ResponseEntity.ok(tasks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getTaskById/{taskId}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable int taskId) throws Exception {
        TaskEntity task = taskService.getTaskById(taskId);
        if (task != null) {
            List<NoteEntity> notes = noteService.getNotesForTask(taskId);
            task.setNotes(notes);
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/addTask")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        TaskEntity task = taskService.addTask(
                body.getTitle(),
                body.getDescription(),
                body.getDeadline()
        );
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/updateTask/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer taskId, @RequestBody UpdateTaskDTO body) throws ParseException {
        TaskEntity task = taskService.updateTask(
                taskId,
                body.getDescription(),
                body.getDeadline(),
                body.isCompleted()
        );
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @ExceptionHandler(ParseException.class)
    public ResponseEntity<ErrorResponseDTO> handleParseError(ParseException e) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid Date Format"));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralError(Exception e) {
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }


}
