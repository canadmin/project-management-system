package com.pms.projectmanagement.services.notificationService;

import com.pms.projectmanagement.dtos.ProjectDto;

public interface NotificationService {

    public void sendInviteNotification(String destinationUser, String fromUser, ProjectDto projectDto);
}
