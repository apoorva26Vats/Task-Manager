//package net.javaguide.Task_Manager.controller;
//
//
//import net.javaguide.Task_Manager.dto.TaskNotesResponseDTO;
//import net.javaguide.Task_Manager.entities.TaskNotesEntity;
//import net.javaguide.Task_Manager.service.TaskNotesService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/tasks/taskNotes")
//public class TaskNotesController {
//    private final TaskNotesService taskNotesService;
//
//    public TaskNotesController(TaskNotesService taskNotesService) {
//        this.taskNotesService = taskNotesService;
//    }
//
//    @GetMapping("/getTaskWithNotes/{taskId}")
//    public ResponseEntity<TaskNotesEntity> getTaskWithNotes(@PathVariable int taskId) {
//        TaskNotesEntity taskNotes = taskNotesService.getTaskWithNotes(taskId);
//
//        if (taskNotes != null) {
//            return ResponseEntity.ok(taskNotes);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/getAllTaskNotes")
//    public ResponseEntity<List<TaskNotesResponseDTO>> getAllTaskNotes() {
//        List<TaskNotesResponseDTO> allTaskNotes = taskNotesService.getAllTaskNotes();
//
//        if (allTaskNotes.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(allTaskNotes);
//    }
//}
