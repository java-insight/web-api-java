package com.jkp.insight.tasks.repository;

import com.jkp.insight.tasks.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByName(String name);
}
