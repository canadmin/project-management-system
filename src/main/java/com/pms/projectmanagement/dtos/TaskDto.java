package com.pms.projectmanagement.dtos;

import com.pms.projectmanagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private int taskNumber;
    private UserDto signedUser;
    private UserDto openedUser;
    private Timestamp dueDate;
    private ProjectDto project;
    private TaskStatus taskStatus;
    private boolean isSigned;
}
