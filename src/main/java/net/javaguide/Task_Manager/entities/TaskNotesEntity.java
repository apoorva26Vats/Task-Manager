package net.javaguide.Task_Manager.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class TaskNotesEntity {
    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private Date taskDeadline;
    private boolean taskCompleted;
    private List<NoteEntity> notes;

}
