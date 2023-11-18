package com.yarvin.tasklist.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "task")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long id;
    private String title;
    private String text;
    private Boolean done;
}
