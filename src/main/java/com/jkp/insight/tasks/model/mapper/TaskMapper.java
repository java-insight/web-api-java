package com.jkp.insight.tasks.model.mapper;

import com.jkp.insight.tasks.model.dto.TaskDto;
import com.jkp.insight.tasks.model.entity.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Log4j2
@Component
//FIXME: THis implementation need to change with standard options in Spring
public class TaskMapper {
    public Task toTask(TaskDto taskDto){
        Task task = new Task();
        System.out.println("TASK MAPPER");
        System.out.println(taskDto);
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
