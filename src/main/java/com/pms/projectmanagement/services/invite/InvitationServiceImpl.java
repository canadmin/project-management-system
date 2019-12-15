package com.pms.projectmanagement.services.invite;

import com.pms.projectmanagement.models.invite.Invitation;
import com.pms.projectmanagement.repositories.invite.InviteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final InviteRepository inviteRepository;
    @Override
    public void inviteDeveloper(String userId, String projectId) {
        inviteRepository.save(Invitation.builder().userId(userId).invitedToProjectId(projectId).build());
    }
}
