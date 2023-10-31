package com.yarvin.tasklist.task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        if(task.getText().isEmpty() ) {
            throw new IllegalStateException("Поле текста пусто");
        }
        if( task.getTitle().isEmpty()){
            throw new IllegalStateException("Поле Заголовка пусто");
        }

        Optional<Task> taskByTitle = taskRepository.findTaskByTitle(task.getTitle());
        if(taskByTitle.isPresent()){
            throw new IllegalStateException("Такая задача уже сущесвтует");
        }

        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if(!taskRepository.existsById(id)){
            throw new IllegalStateException("Задачи с id " + id +" не существует");
        }
        taskRepository.deleteById(id);
    }

    @Transactional
    public void updateTask(Long taskId, boolean done) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Задачи с id " + taskId +" не существует"));
        task.setDone(done);
    }


}
