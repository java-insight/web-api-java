package com.jkp.insight.tasks.service.impl;

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
        List<TaskDto> taskDtoList = taskList.stream().map(t -> taskMapper.toTaskDto(t)).collect(Collectors.toList());
        return taskDtoList;
    }

    @Override
    public TaskDto getTask(Integer id) {
        Task task = taskRepository.getOne(id);
        //TODO: Check the object exists, if not throw Exception
        return taskMapper.toTaskDto(task);
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.toTask(taskDto);
        return taskMapper.toTaskDto(taskRepository.saveAndFlush(task));
    }

    @Override
    public TaskDto updateTask(Integer id, TaskDto taskDto) {
        Task task = taskRepository.getOne(id);
        //TODO: Check the object exists, if not throw Exception
        task = taskMapper.updateTask(taskDto,task);
        return taskMapper.toTaskDto(taskRepository.saveAndFlush(task));
    }

    @Override
    public void deleteTask(Integer id) {
        Task task = taskRepository.getOne(id);
        //TODO: Check the object exists, if not throw Exception
        taskRepository.deleteById(id);
    }
}
