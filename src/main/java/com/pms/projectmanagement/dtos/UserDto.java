package com.pms.projectmanagement.dtos;


import com.pms.projectmanagement.models.Project;
import com.pms.projectmanagement.models.Task;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID id;

    private String firstName;
    private String lastName;
    private String fullName;

    private String username;
    private String email;
    private String password;

    private String roleType;

    private Boolean isMailActive;
    private Timestamp createdDate;

    private List<ProjectDto> ownedProjects;

    private List<Project> projects;

    private List<Task> signedTasks;

    private List<Task> openedTasks;
}
