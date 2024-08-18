package org.example2.todobackend.repository;

import org.example2.todobackend.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<TaskEntity, String> {
}
