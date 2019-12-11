package com.pms.projectmanagement.services.task;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.dtos.TaskDto;

import java.util.UUID;

public interface TaskService {

    void createNewTask(UUID projectId, UUID userId, TaskDto taskDto,String username);
}
