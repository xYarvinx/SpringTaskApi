package com.yarvin.tasklist.controller;


import com.yarvin.tasklist.dto.*;
import com.yarvin.tasklist.exceptions.*;
import com.yarvin.tasklist.services.TaskService;
import com.yarvin.tasklist.models.Task;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/task")
@RequiredArgsConstructor
@TaskControllerExceptionHandler
public class TaskController {


    private final TaskService taskService ;
    private final ModelMapper taskMapper;

    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponseDto> getTasks() {
        List<Task>tasks = taskService.getTasks();
        List<TaskResponseDto> taskResponseAllDtos = new ArrayList<>();

        for (Task task : tasks) {
            TaskResponseDto taskResponseAllDto = taskMapper.map(task, TaskResponseDto.class);
            taskResponseAllDtos.add(taskResponseAllDto);
        }
        if(taskResponseAllDtos.isEmpty()){
            throw new TaskNotFoundException("Список задач пуст");
        }

        return taskResponseAllDtos;
    }
    @GetMapping(path = "{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponseDto getTask(@PathVariable long taskId){
       Task task = taskService.findTaskById(taskId);
       TaskResponseDto taskDto = taskMapper.map(task, TaskResponseDto.class);

       return taskDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskCreationResponseDto addNewTask(@RequestBody TaskCreationDto creationDto){
        if(creationDto.getTitle() == null){
            throw new TaskCreateException("Поле заголовка не должно быть пустым");
        }
        if(creationDto.getText() == null){
            throw new TaskCreateException("Поле текста не должно быть пустым");
        }

        Task newTask = taskMapper.map(creationDto, Task.class);

        taskService.addNewTask(newTask);

        var taskId = newTask.getId();
        var taskCreationResponseDto = new TaskCreationResponseDto().setId(taskId);

        return taskCreationResponseDto;
    }

    @DeleteMapping(path = "{taskId}")
    public TaskDeleteResponseDto deleteTask(@PathVariable("taskId") Long id){
        taskService.deleteTask(id);
        var taskDeleteResponseDto = new TaskDeleteResponseDto().setId(id);
        return taskDeleteResponseDto;
    }

    @PutMapping(path = "{taskId}")
    public TaskUpdateResposeDto updateTask(@PathVariable("taskId") Long taskId,@RequestBody TaskDoneUpdateDto taskDoneUpdateDto){
        var newDone = taskDoneUpdateDto.getDone();
        if(newDone == null){
            throw new TaskPutException("Поле для изменений пусто");
        }
        taskService.updateTask(taskId, newDone);
        var taskUpdateResposeDto = new TaskUpdateResposeDto().setId(taskId);

        return taskUpdateResposeDto;
    }
}
