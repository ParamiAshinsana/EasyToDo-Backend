package org.example2.todobackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example2.todobackend.dto.TaskDTO;
import org.example2.todobackend.mapping.TaskMapping;
import org.example2.todobackend.repository.TaskRepository;
import org.example2.todobackend.service.TaskService;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceIMPL implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapping taskMapping;


    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        return null;
    }
}
