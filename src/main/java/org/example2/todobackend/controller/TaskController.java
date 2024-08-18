package org.example2.todobackend.controller;

import lombok.RequiredArgsConstructor;
import org.example2.todobackend.dto.TaskDTO;
import org.example2.todobackend.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {
    private final TaskService taskService;


    @PostMapping(value = "/saveTask")
    public TaskDTO saveTasks(@RequestBody TaskDTO taskDTO){
        return taskService.saveTask(taskDTO);
    }

}
