package com.pms.projectmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskCommentDto {
    private UUID id;

    private UserDto signedUser;

    private TaskDto task;

    private String comment;

    private String issueNumber;

    private UUID projectId;
}
