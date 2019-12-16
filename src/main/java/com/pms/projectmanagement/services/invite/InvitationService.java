package com.pms.projectmanagement.services.invite;

import com.pms.projectmanagement.models.invite.Invitation;

import java.util.UUID;

public interface InvitationService {

    void inviteDeveloper(String userId, String projectId);

    Invitation getInvitation(String userId);
}
