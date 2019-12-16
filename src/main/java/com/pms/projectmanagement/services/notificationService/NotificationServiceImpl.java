package com.pms.projectmanagement.services.notificationService;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.elasticsearch.model.UserES;
import com.pms.projectmanagement.elasticsearch.repository.UserRepositoryES;
import com.pms.projectmanagement.elasticsearch.repository.notification.NotificationRepository;
import com.pms.projectmanagement.enums.NotificationType;
import com.pms.projectmanagement.elasticsearch.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final SimpMessagingTemplate messagingTemplate;
    private final UserRepositoryES userRepositoryES;

    private final NotificationRepository notificationRepository;
    @Override
    public void sendInviteNotification(String destinationUserId, String fromUser, ProjectDto projectDto) {

        Optional<UserES> userES = userRepositoryES.findById(destinationUserId);

        Notification notification = Notification.builder()
                .id(UUID.randomUUID().toString())
                .senderName(fromUser)
                .notificationMessage(fromUser+" Invite your " +projectDto.getProjectName() + " project !!")
                .receiverId(destinationUserId)
                .isRead(false).projectId(projectDto.getId().toString())
                .notificationType(NotificationType.INVITE)
                .build();
        this.messagingTemplate.convertAndSendToUser(userES.get().getUsername(),"/notification/to/",notification);
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> showAllNotification(String userId) {

        List<Notification> notifications = notificationRepository.findAllByReceiverId(userId);

        return notifications;
    }
}
