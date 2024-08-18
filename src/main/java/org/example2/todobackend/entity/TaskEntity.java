package org.example2.todobackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    private String taskId;
    private String taskDescription;
    private LocalDate issuedDate;
    private LocalTime issuedTime;
}
