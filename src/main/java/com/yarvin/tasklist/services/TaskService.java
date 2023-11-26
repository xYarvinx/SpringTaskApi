package com.yarvin.tasklist.services;

import com.yarvin.tasklist.dto.TaskDto;
import com.yarvin.tasklist.exceptions.ExistException;
import com.yarvin.tasklist.exceptions.NullException;
import com.yarvin.tasklist.config.mapper.TaskMapper;
import com.yarvin.tasklist.models.Task;
import com.yarvin.tasklist.repo.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<TaskDto> getTasks() {
        return taskMapper.toDto(taskRepository.findAll());
    }

    public void addNewTask(Task task) {
        if (task.getText().isEmpty()) {
            throw new NullException(NullException.NULL_TEXT);
        }
        if (task.getTitle().isEmpty()) {
            throw new NullException(NullException.NULL_TITLE);
        }

        Optional<Task> taskByTitle = taskRepository.findTaskByTitle(task.getTitle());
        if (taskByTitle.isPresent()) {
            throw new ExistException(ExistException.TASK_EXIST);
        }

        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new NullException(id);
        }
        taskRepository.deleteById(id);
    }

    @Transactional
    public void updateTask(Long taskId, boolean done) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NullException(taskId));
        task.setDone(done);
    }

    public Task findTaskById(long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new NullException(taskId));
    }
}
