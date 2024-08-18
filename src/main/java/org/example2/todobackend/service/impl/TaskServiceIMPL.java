package org.example2.todobackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example2.todobackend.dto.TaskDTO;
import org.example2.todobackend.mapping.TaskMapping;
import org.example2.todobackend.repository.TaskRepository;
import org.example2.todobackend.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceIMPL implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapping taskMapping;

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {

        // Assign current date if issuedDate is not provided
        if (taskDTO.getIssuedDate() == null) {
            taskDTO.setIssuedDate(LocalDate.now());
        }

        // Assign current time if issuedTime is not provided
        if (taskDTO.getIssuedTime() == null) {
            taskDTO.setIssuedTime(LocalTime.now());
        }

        taskDTO.setTaskId(UUID.randomUUID().toString());
        return taskMapping.toTaskDTO(taskRepository.save(taskMapping.toTask(taskDTO)));
    }
}
