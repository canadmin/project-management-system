package com.pms.projectmanagement.dtos;

import com.pms.projectmanagement.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private UUID id;

    private String projectName;

    private String projectDescription;

    private User owner;
}
