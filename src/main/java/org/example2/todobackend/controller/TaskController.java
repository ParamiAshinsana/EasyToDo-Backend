package org.example2.todobackend.controller;

import lombok.RequiredArgsConstructor;
import org.example2.todobackend.dto.TaskDTO;
import org.example2.todobackend.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {
    private final TaskService taskService;


    @PostMapping(value = "/saveTask")
    public TaskDTO saveTasks(@RequestBody TaskDTO taskDTO){
        return taskService.saveTask(taskDTO);
    }

    @DeleteMapping(value = "/deleteTask/{id}")
    public void deleteTasks(@PathVariable ("id") String id){
        taskService.deleteTask(id);
    }

    @PutMapping(value = "/updateTask/{id}")
    public void updateTasks(@RequestBody TaskDTO taskDTO, @PathVariable ("id") String id){
        taskService.updateTask(id,taskDTO);
        System.out.println("User Updated!");
    }

    @GetMapping(value = "/getAllTasks")
    List<TaskDTO> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/getSelectedTask/{id}")
    ResponseEntity<TaskDTO> getSelectedTask(@PathVariable ("id") String id){
        TaskDTO selectedTask = taskService.getSelectedTask(id);
        return selectedTask != null ? ResponseEntity.ok(selectedTask) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
