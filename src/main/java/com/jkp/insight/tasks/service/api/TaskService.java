package com.jkp.insight.tasks.service.api;

import com.jkp.insight.tasks.model.dto.TaskDto;

import java.util.List;

public interface TaskService {
    public List<TaskDto> getAllTasks();
    public List<TaskDto> searchTask(String name);
    public TaskDto readTask(Integer id);
    public TaskDto createTask(TaskDto taskDto);
    public TaskDto updateTask(Integer id, TaskDto taskDto);
    public void deleteTask(Integer id);
}
