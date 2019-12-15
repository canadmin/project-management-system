package com.pms.projectmanagement.services.project;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.models.Project;
import com.pms.projectmanagement.models.User;
import com.pms.projectmanagement.repositories.ProjectRepository;
import com.pms.projectmanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectDto createProject(ProjectDto projectDto, UUID ownerId) {
        Optional<User>  user = userRepository.findById(ownerId);
        Project project = modelMapper.map(projectDto,Project.class);
        List<User> developers = new ArrayList<>();
        developers.add(user.get());
        project.setOwner(user.get());
        project.setDevelopers(developers);
        Project createdProject = projectRepository.save(project);
        return modelMapper.map(createdProject,ProjectDto.class);
    }

    @Override
    public ProjectDto getProjectInfo(UUID projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        return modelMapper.map(project.get(),ProjectDto.class);
    }
}
