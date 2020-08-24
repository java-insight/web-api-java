package com.jkp.insight.tasks.controller;

import com.jkp.insight.tasks.exception.BaseException;
import com.jkp.insight.tasks.exception.ValidationException;
import com.jkp.insight.tasks.model.dto.TaskDto;
import com.jkp.insight.tasks.model.entity.Task;
import com.jkp.insight.tasks.repository.TaskRepository;
import com.jkp.insight.tasks.service.api.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public List<TaskDto> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/search")
    public List<TaskDto> searchTasks(@RequestParam(required = false) String name) {
        if (name != null) {
            return taskService.searchTask(name);
        } else {
            return taskService.getAllTasks();
        }
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable final Integer id) {
        return new ResponseEntity(taskService.getTask(id), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<TaskDto> createTask(final TaskDto taskDto) {
        return new ResponseEntity(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<TaskDto> updateTask(@PathVariable final Integer id, final TaskDto taskDto) {
        return new ResponseEntity(taskService.updateTask(id, taskDto), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTask(@PathVariable final Integer id) {
        taskService.deleteTask(id);
        return new ResponseEntity<String>("Task Deleted.", HttpStatus.OK);
    }

    @ExceptionHandler(BaseException.class)
    ResponseEntity<String> exceptionHandler(BaseException e) {
        return new ResponseEntity(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }
}
