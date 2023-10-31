package com.yarvin.tasklist.task;

import jakarta.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )

    private Long id;
    private String title;
    private String text;
    private Boolean done;

    public Task() {
    }

    public Task(Long id, String title, String text, Boolean done) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.done = done;
    }

    public Task(String title, String text, Boolean done) {
        this.title = title;
        this.text = text;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", done=" + done +
                '}';
    }
}
