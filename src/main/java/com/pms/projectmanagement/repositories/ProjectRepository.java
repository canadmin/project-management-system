package com.pms.projectmanagement.repositories;

import com.pms.projectmanagement.models.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProjectRepository extends CrudRepository<Project, UUID> {
}
