package com.yarvin.tasklist.controller;

import com.yarvin.tasklist.dto.TaskDto;
import com.yarvin.tasklist.services.TaskService;
import com.yarvin.tasklist.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/task")
@RequiredArgsConstructor
public class TaskController {


    private final TaskService taskService ;


    @GetMapping
    public List<TaskDto> getTasks() {
        return taskService.getTasks();
    }
    @GetMapping(path = "{taskId}")
    public Task getTask(@PathVariable long taskId){
       return taskService.findTaskById(taskId);
    }

    @PostMapping
    public void addNewTask(@RequestBody Task task){
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long id){
        taskService.deleteTask(id);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(@PathVariable("taskId") Long taskId,@RequestParam(required = false) boolean done){
        taskService.updateTask(taskId, done);
    }
}
