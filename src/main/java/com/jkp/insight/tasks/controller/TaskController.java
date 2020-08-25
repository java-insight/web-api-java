package com.jkp.insight.tasks.controller;

import com.jkp.insight.tasks.model.dto.TaskDto;
import com.jkp.insight.tasks.repository.TaskRepository;
import com.jkp.insight.tasks.service.api.TaskService;
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
    public ResponseEntity<List<TaskDto>> getTasks() {
        return new ResponseEntity(taskService.getAllTasks(),HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<TaskDto> searchTasks(@RequestParam(required = false) String name) {
        if (name != null) {
            return taskService.searchTask(name);
        } else {
            return taskService.getAllTasks();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<TaskDto> createTask(final TaskDto taskDto) {
        return new ResponseEntity(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<TaskDto> readTask(@PathVariable final Integer id) {
        return new ResponseEntity(taskService.readTask(id), HttpStatus.OK);
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
}
