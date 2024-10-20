package net.javaguide.Task_Manager.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class NoteEntity {
    private int id;
    private String title;
    private String body;

}

