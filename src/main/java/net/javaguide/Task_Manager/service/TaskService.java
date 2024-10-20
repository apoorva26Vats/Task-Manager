package net.javaguide.Task_Manager.service;

import net.javaguide.Task_Manager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@Service
public class TaskService {

    private int taskId = 1;
    private ArrayList<TaskEntity> tasks = new ArrayList<>();

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    private SimpleDateFormat deadlineFormater = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTask(String title, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadlineFormater.parse(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }

    public TaskEntity getTaskById(int taskId) {
        for (TaskEntity task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public TaskEntity updateTask(int taskId, String description, String deadline, boolean completed) throws ParseException {
        TaskEntity task = getTaskById(taskId);
        if(task == null) {
            return null;
        }
        if(description != null) {
            task.setDescription(description);
        }
        if(deadline != null) {
            task.setDeadline(deadlineFormater.parse(deadline));
        }
        task.setCompleted(completed);
        return task;
    }


}
