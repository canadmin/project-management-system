package com.pms.projectmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pms.projectmanagement.enums.TaskStatus;
import com.pms.projectmanagement.models.TaskComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private UUID id;

    private int taskNumber;
    private UserDto signedUser;
    private UserDto openedUser;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    private ProjectDto project;
    private TaskStatus taskStatus;
    private boolean isSigned;
    private List<TaskComment> taskComments;
    private String taskDescription;
    private String taskTitle;


}
