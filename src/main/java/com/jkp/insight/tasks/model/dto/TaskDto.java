package com.jkp.insight.tasks.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    public Integer id;
    public String name;
    public Boolean isComplete = false;
}