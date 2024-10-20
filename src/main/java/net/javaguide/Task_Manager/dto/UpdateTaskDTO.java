package net.javaguide.Task_Manager.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskDTO {

	private String description;
    private String deadline;
    private boolean completed;

}