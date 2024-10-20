package net.javaguide.Task_Manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguide.Task_Manager.entities.NoteEntity;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteResponseDTO {
    
	private Integer taskId;
    private NoteEntity note;

}
