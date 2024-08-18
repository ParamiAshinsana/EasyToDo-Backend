package org.example2.todobackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example2.todobackend.dto.TaskDTO;
import org.example2.todobackend.entity.TaskEntity;
import org.example2.todobackend.exception.NotFoundException;
import org.example2.todobackend.mapping.TaskMapping;
import org.example2.todobackend.repository.TaskRepository;
import org.example2.todobackend.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceIMPL implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapping taskMapping;

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {

        if (taskDTO.getIssuedDate() == null) {
            taskDTO.setIssuedDate(LocalDate.now());
        }

        if (taskDTO.getIssuedTime() == null) {
            taskDTO.setIssuedTime(LocalTime.now());
        }

        taskDTO.setTaskId(UUID.randomUUID().toString());
        return taskMapping.toTaskDTO(taskRepository.save(taskMapping.toTask(taskDTO)));
    }

    @Override
    public void deleteTask(String id) {
        if(!taskRepository.existsById(id)) throw new NotFoundException("User not found");
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTask(String id, TaskDTO taskDTO) {
        Optional<TaskEntity> tmpUser = taskRepository.findById(id);
        if(!tmpUser.isPresent()) throw new NotFoundException("Task not found");

        tmpUser.get().setTaskDescription(taskDTO.getTaskDescription());

        // Check and set issuedDate and issuedTime
        if (taskDTO.getIssuedDate() == null) {
            taskDTO.setIssuedDate(LocalDate.now());
        }
        if (taskDTO.getIssuedTime() == null) {
            taskDTO.setIssuedTime(LocalTime.now());
        }
        tmpUser.get().setIssuedDate(taskDTO.getIssuedDate());
        tmpUser.get().setIssuedTime(taskDTO.getIssuedTime());

    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskMapping.toTaskDTOList(taskRepository.findAll());
    }

    @Override
    public TaskDTO getSelectedTask(String id) {
        if(!taskRepository.existsById(id)) throw new NotFoundException("User not found");
        return taskMapping.toTaskDTO(taskRepository.getReferenceById(id));
    }
}
