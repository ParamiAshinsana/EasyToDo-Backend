package org.example2.todobackend.service;

import org.example2.todobackend.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO saveTask(TaskDTO taskDTO);

    void deleteTask(String id);

    void updateTask(String id, TaskDTO taskDTO);

    List<TaskDTO> getAllTasks();

    TaskDTO getSelectedTask(String id);
}
