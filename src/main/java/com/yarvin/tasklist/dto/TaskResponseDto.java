package com.yarvin.tasklist.dto;

import lombok.Data;

@Data
public class TaskResponseDto {
    private String title;
    private String text;
    private Boolean done;
}
