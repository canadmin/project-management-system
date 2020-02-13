package com.pms.projectmanagement.services.invitation;

import com.pms.projectmanagement.dtos.ProjectDto;

public interface InvitationService {
    ProjectDto joinProject(String projectId,String receiverId,String notificationId);
}
