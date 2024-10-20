package net.javaguide.Task_Manager.service;

import net.javaguide.Task_Manager.dto.TaskNotesResponseDTO;
import net.javaguide.Task_Manager.entities.NoteEntity;
import net.javaguide.Task_Manager.entities.TaskEntity;
import net.javaguide.Task_Manager.entities.TaskNotesEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskNotesService {
    private final TaskService taskService;
    private final NoteService noteService;

    public TaskNotesService(TaskService taskService, NoteService noteService) {
        this.taskService = taskService;
        this.noteService = noteService;
    }

    public TaskNotesEntity getTaskWithNotes(int taskId) {
        TaskEntity task = taskService.getTaskById(taskId);
        if (task == null) {
            return null;
        }
        List<NoteEntity> notes = noteService.getNotesForTask(taskId);
        TaskNotesEntity taskNotesEntity = new TaskNotesEntity();
        taskNotesEntity.setTaskId( task.getId() );
        taskNotesEntity.setTaskTitle( task.getTitle() );
        taskNotesEntity.setTaskDescription( task.getDescription() );
        taskNotesEntity.setTaskDeadline( task.getDeadline() );
        taskNotesEntity.setTaskCompleted( task.isCompleted() );
        taskNotesEntity.setNotes(notes);
        return taskNotesEntity;
    }

    public List<TaskNotesResponseDTO> getAllTaskNotes() {
        List<TaskEntity> tasks = taskService.getTasks();
        List<TaskNotesResponseDTO> allTaskNotes = new ArrayList<>();

        for (TaskEntity task : tasks) {
            List<NoteEntity> notes = noteService.getNotesForTask(task.getId());

            TaskNotesResponseDTO taskNotesResponseDTO = new TaskNotesResponseDTO(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getDeadline(),
                    task.isCompleted(),
                    notes != null ? notes : new ArrayList<>()
            );
            allTaskNotes.add(taskNotesResponseDTO);
        }
        return allTaskNotes;
    }
}
