package com.yarvin.tasklist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/task")
public class TaskController {


    private final TaskService taskService ;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
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
