package net.javaguide.Task_Manager.service;


import net.javaguide.Task_Manager.entities.NoteEntity;
import net.javaguide.Task_Manager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {

    private TaskService taskService;
    private HashMap<Integer , TaskNotesHolder> taskNoteHolders = new HashMap<>();

    public NoteService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNotesHolder {
        protected int noteID = 1;
        protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }

    public List<NoteEntity> getAllNotes() {
        List<NoteEntity> allNotes = new ArrayList<>();
        for (TaskEntity task : taskService.getTasks()) {
            TaskNotesHolder taskNotesHolder = taskNoteHolders.get(task.getId());
            if (taskNotesHolder != null) {
                allNotes.addAll(taskNotesHolder.notes);
            }
        }
        return allNotes;
    }


    public List<NoteEntity> getNotesForTask(int taskId) {
        TaskEntity task = taskService.getTaskById(taskId);
        if (task == null) {
            return null;
        }
        if (taskNoteHolders.get(taskId) == null) {
            taskNoteHolders.put(taskId, new TaskNotesHolder());
        }
        return taskNoteHolders.get(taskId).notes;
    }


    public NoteEntity addNoteForTask(int taskId, String title, String body) {
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null) {
            return null;
        }
        if(taskNoteHolders.get(taskId) == null) {
            taskNoteHolders.put(taskId, new TaskNotesHolder());
        }
        TaskNotesHolder taskNoteHolder = taskNoteHolders.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNoteHolder.noteID);
        note.setTitle(title);
        note.setBody(body);
        taskNoteHolder.notes.add(note);
        taskNoteHolder.noteID++;
        return note;
    }
}