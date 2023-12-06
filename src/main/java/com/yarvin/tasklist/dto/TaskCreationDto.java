package com.yarvin.tasklist.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TaskCreationDto {
    private long id;
    private String title;
    private String text;
    private Boolean done;

}
