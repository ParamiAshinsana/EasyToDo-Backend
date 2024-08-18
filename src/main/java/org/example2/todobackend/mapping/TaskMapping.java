package org.example2.todobackend.mapping;

import lombok.RequiredArgsConstructor;
import org.example2.todobackend.dto.TaskDTO;
import org.example2.todobackend.entity.TaskEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskMapping {
    private final ModelMapper mapper;

    public TaskDTO toTaskDTO(TaskEntity taskEntity) {
        return  mapper.map(taskEntity, TaskDTO.class);
    }
    public TaskEntity toTask(TaskDTO taskDTO) {
        return  mapper.map(taskDTO, TaskEntity.class);
    }
    public List<TaskDTO> toTaskDTOList(List<TaskEntity> taskEntities) {
        return mapper.map(taskEntities, List.class);
    }
}
