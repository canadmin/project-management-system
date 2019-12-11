package com.pms.projectmanagement.dtos;

import com.pms.projectmanagement.models.Task;
import com.pms.projectmanagement.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private UUID id;

    private String projectName;

    private String projectDescription;

    private UserDto owner;

    private Timestamp createdDate;

    private String githubRepoAddress;

    private List<Task> tasks;

    private List<User> developers;
}
