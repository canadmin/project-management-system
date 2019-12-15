package com.pms.projectmanagement.services.notificationService;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.elasticsearch.model.UserES;
import com.pms.projectmanagement.elasticsearch.repository.UserRepositoryES;
import com.pms.projectmanagement.notifications.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final SimpMessagingTemplate messagingTemplate;
    private final UserRepositoryES userRepositoryES;
    @Override
    public void sendInviteNotification(String destinationUserId, String fromUser, ProjectDto projectDto) {

        Optional<UserES> userES = userRepositoryES.findById(destinationUserId);

        Notification notification = Notification.builder()
                .senderName(fromUser)
                .notificationMessage(fromUser+" Invite your " +projectDto.getProjectName() + " project !!")
                .receiverId(destinationUserId)
                .build();

        this.messagingTemplate.convertAndSendToUser(userES.get().getUsername(),"/notification/to/",notification);
    }
}
