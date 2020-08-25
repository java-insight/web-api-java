package com.jkp.insight.tasks.controller.fault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskFault {
    private Integer status;
    private String message;
}
