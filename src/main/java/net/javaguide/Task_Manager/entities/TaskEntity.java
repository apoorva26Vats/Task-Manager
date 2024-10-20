package net.javaguide.Task_Manager.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;
    private List<NoteEntity> notes;

}
