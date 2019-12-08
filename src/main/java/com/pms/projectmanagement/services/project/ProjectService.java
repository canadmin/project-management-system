package com.pms.projectmanagement.services.project;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.models.Project;
import com.pms.projectmanagement.models.User;

import java.util.UUID;

public interface ProjectService {

    ProjectDto createProject(ProjectDto projectDto, UUID ownerId);

}
