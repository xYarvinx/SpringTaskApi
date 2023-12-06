package com.yarvin.tasklist.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskUpdateResposeDto {
    public long id;
}
