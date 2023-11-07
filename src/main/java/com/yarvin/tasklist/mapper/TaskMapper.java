package com.yarvin.tasklist.mapper;

import com.yarvin.tasklist.dto.TaskDto;
import com.yarvin.tasklist.models.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public TaskDto toDto(Task task){
        return modelMapper.map(task, TaskDto.class);
    }

    public List<TaskDto> toDto(List<Task> all) {
        List<TaskDto> taskDtos = new ArrayList<>();
        for (Task task : all) {
            TaskDto taskDto = modelMapper.map(task, TaskDto.class);
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }
}
