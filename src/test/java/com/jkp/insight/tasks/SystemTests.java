package com.jkp.insight.tasks;

import com.jkp.insight.tasks.controller.TaskController;
import com.jkp.insight.tasks.model.dto.TaskDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigurationPackage
public class SystemTests {

    @LocalServerPort
    private int port;

    @Autowired
    TaskController taskController;

    Integer ID = 1;
    String TASK_NAME = "Design";

    @Test
    public void testCRUD(){

        // CREATE
        ResponseEntity<TaskDto> entity = taskController.createTask(new TaskDto().setName(TASK_NAME));
        assertEquals(HttpStatus.CREATED,entity.getStatusCode());
        Assertions.assertThat(entity.getBody()).extracting(TaskDto::getId).isEqualTo(ID);

        // UPDATE
        taskController.updateTask(ID, new TaskDto().setIsComplete(true));
        Assertions.assertThat(taskController.readTask(ID).getBody()).extracting(TaskDto::getIsComplete).isEqualTo(true);

        // DELETE
        taskController.deleteTask(ID);
        Assertions.assertThat(taskController.getTasks().getBody()).isEmpty();
    }


}
