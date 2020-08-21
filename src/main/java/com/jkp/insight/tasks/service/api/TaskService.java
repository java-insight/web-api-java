package com.jkp.insight.tasks.service.api;

import com.jkp.insight.tasks.model.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {
    public List<TaskDto> getAllTasks();
    public TaskDto getTask(Integer id);
    public TaskDto createTask(TaskDto taskDto);
    public TaskDto updateTask(Integer id, TaskDto taskDto);
    public void deleteTask(Integer id);

}
