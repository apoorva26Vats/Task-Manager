package net.javaguide.Task_Manager.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguide.Task_Manager.entities.NoteEntity;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskNotesResponseDTO {
	
	private int taskId;
    private String taskTitle;
    private String taskDescription;
    private Date taskDeadline;
    private boolean taskCompleted;
    private List<NoteEntity> notes;

}
