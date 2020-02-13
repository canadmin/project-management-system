package com.pms.projectmanagement.services.invitation;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.models.Project;
import com.pms.projectmanagement.models.User;
import com.pms.projectmanagement.repositories.ProjectRepository;
import com.pms.projectmanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    @Override
    public ProjectDto joinProject(String projectId, String receiverId) {

        Optional<Project> project = projectRepository.findById(UUID.fromString(projectId));
        Optional<User> user = userRepository.findById(UUID.fromString(receiverId));

        List<User> developers = project.get().getDevelopers();
        developers.add(user.get());
        project.get().setDevelopers(developers);

        projectRepository.save(project.get());
        return null;
    }
}
