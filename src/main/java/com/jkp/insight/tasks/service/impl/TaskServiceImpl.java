package com.jkp.insight.tasks.service.impl;

import com.jkp.insight.tasks.exception.ErrorMessages;
import com.jkp.insight.tasks.exception.TaskException;
import com.jkp.insight.tasks.exception.ValidationException;
import com.jkp.insight.tasks.model.dto.TaskDto;
import com.jkp.insight.tasks.model.entity.Task;
import com.jkp.insight.tasks.model.mapper.TaskMapper;
import com.jkp.insight.tasks.repository.TaskRepository;
import com.jkp.insight.tasks.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(t -> taskMapper.toTaskDto(t)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> searchTask(String name) {
        List<Task> taskList = taskRepository.findByName(name);
        return taskList.stream().map(t -> taskMapper.toTaskDto(t)).collect(Collectors.toList());
    }
    @Override
    public TaskDto readTask(Integer id) {
        Task task = taskRepository.findById(id).
                orElseThrow(new TaskException(String.format(ErrorMessages.TASK_NOT_EXISTS,id)));
        return taskMapper.toTaskDto(task);
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        if (taskDto.getName() != null) {
            Task task = taskMapper.toTask(taskDto);
            return taskMapper.toTaskDto(taskRepository.saveAndFlush(task));
        } else {
            throw new ValidationException("Failed to create Task. Task Name is Null or Empty.");
        }
    }

    @Override
    public TaskDto updateTask(Integer id, TaskDto taskDto) {
        Task task = taskRepository.findById(id).
                orElseThrow(new TaskException(String.format(ErrorMessages.TASK_NOT_EXISTS,id)));
        task = taskMapper.updateTask(taskDto,task);
        return taskMapper.toTaskDto(taskRepository.saveAndFlush(task));
    }

    @Override
    public void deleteTask(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(new TaskException(String.format(ErrorMessages.TASK_NOT_EXISTS,id)));
        taskRepository.deleteById(id);
    }
}
