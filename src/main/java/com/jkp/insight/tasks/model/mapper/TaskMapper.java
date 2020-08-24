package com.jkp.insight.tasks.model.mapper;

import com.jkp.insight.tasks.model.dto.TaskDto;
import com.jkp.insight.tasks.model.entity.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
//FIXME: THis implementation need to change with standard options in Spring
public class TaskMapper {
    public Task toTask(TaskDto taskDto){
        Task task = new Task();
        BeanUtils.copyProperties(taskDto,task);
        return task;

    }
    public TaskDto toTaskDto(Task task){
        TaskDto taskDto = new TaskDto();
        BeanUtils.copyProperties(task,taskDto);
        return taskDto;
    }
    public Task updateTask(TaskDto taskDto,Task task){
        String[] ignoreFields = {"id","name"};
        BeanUtils.copyProperties(taskDto,task,ignoreFields);
        return task;
    }
}
