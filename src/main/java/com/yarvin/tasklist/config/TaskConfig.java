package com.yarvin.tasklist.config;

import com.yarvin.tasklist.repo.TaskRepository;
import com.yarvin.tasklist.models.Task;
import com.yarvin.tasklist.task.Task;
import com.yarvin.tasklist.task.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner (TaskRepository repository) {
        return args -> {
               com.yarvin.tasklist.task.Task task_1 = new com.yarvin.tasklist.task.Task(
                        "Выполнить лабу 3 любой ценой",
                        "Напишите контроллер в проекте и добавьте в него несколько методов для GET, POST, PUT, DELETE\n" +
                                "\n" +
                                "Также сделайте DTO классы (несколько) для частичного обновления полей пользователя. \n" +
                                "\n" +
                                "Также опишите коды ответов на те случаи, когда что-то идет не так",
                        false
                );

               com.yarvin.tasklist.task.Task task_2 = new Task(
                       "Выкинуть мусор",
                       "Много мусора накопилось, пора бы выкинуть",
                       true
               );

               repository.saveAll(List.of(task_1,task_2));
        };
    }
}
