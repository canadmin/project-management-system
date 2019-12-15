package com.pms.projectmanagement.notifications.notificationService;

import com.pms.projectmanagement.dtos.ProjectDto;

public interface NotificationService {

    public void sendInviteNotification(String destinationUser, String fromUserId, ProjectDto projectDto);
}
