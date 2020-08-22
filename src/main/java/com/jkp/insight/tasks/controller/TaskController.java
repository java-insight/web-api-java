package com.jkp.insight.tasks.controller;

import com.jkp.insight.tasks.model.dto.TaskDto;
import com.jkp.insight.tasks.model.entity.Task;
import com.jkp.insight.tasks.repository.TaskRepository;
import com.jkp.insight.tasks.service.api.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
/*
TODO :
 - Authorize Request
 - Input validation
 */
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDto> getTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping
    @RequestMapping("{id}")
    public TaskDto getTask(@PathVariable final Integer id){
        return taskService.getTask(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto createTask( final TaskDto taskDto){
        return taskService.createTask(taskDto);
    }

    @PutMapping(value="{id}",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto updateTask(@PathVariable final Integer id, final TaskDto taskDto){
        return taskService.updateTask(id,taskDto);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable final Integer id){
        taskService.deleteTask(id);
    }
}
