package com.pms.projectmanagement.services.project;

import com.pms.projectmanagement.dtos.ProjectDto;

import java.util.UUID;

public interface ProjectService {

    ProjectDto createProject(ProjectDto projectDto, UUID ownerId);

    ProjectDto getProjectInfo(UUID projectId);

}
