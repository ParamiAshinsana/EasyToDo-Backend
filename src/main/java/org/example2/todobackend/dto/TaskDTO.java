package org.example2.todobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {
    private String taskId;
    private String taskDescription;
    private LocalDate issuedDate;
    private LocalTime issuedTime;
}
