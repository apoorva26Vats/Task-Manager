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
public class TaskResponseDTO {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;
    private List<NoteEntity> notes;

}
