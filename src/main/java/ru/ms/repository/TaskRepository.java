package ru.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ms.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    
}
