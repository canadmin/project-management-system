package com.pms.projectmanagement.services.invitation;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.elasticsearch.model.Notification;
import com.pms.projectmanagement.elasticsearch.repository.notification.NotificationRepository;
import com.pms.projectmanagement.models.Project;
import com.pms.projectmanagement.models.User;
import com.pms.projectmanagement.repositories.ProjectRepository;
import com.pms.projectmanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;
    private final ModelMapper modelMapper;
    @Override
    public ProjectDto joinProject(String projectId, String receiverId,String notificationId) {

        Optional<Project> project = projectRepository.findById(UUID.fromString(projectId));
        Optional<User> user = userRepository.findById(UUID.fromString(receiverId));


        List<User> developers = project.get().getDevelopers();
        boolean userExist = developers.stream()
                .anyMatch(x-> x.getId().equals(UUID.fromString(receiverId)));
        if (!userExist){
            developers.add(user.get());
            project.get().setDevelopers(developers);
            projectRepository.save(project.get());
        }


        Optional<Notification> notification = notificationRepository.findById(notificationId);
        notification.get().setAvailable(false);
        notificationRepository.save(notification.get());
        return modelMapper.map(project.get(),ProjectDto.class);
    }
}
