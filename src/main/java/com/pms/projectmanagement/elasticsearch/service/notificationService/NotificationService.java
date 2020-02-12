package com.pms.projectmanagement.elasticsearch.service.notificationService;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.elasticsearch.model.Notification;

import java.util.List;

public interface NotificationService {

    public void sendInviteNotification(String destinationUser, String fromUser, ProjectDto projectDto);

    List<Notification> showAllNotification(String userId);
}
