package com.pms.projectmanagement.services.invite;

import com.pms.projectmanagement.models.invite.Invite;
import com.pms.projectmanagement.repositories.invite.InviteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InviteServiceImpl implements InviteService {

    private final InviteRepository inviteRepository;
    @Override
    public void inviteDeveloper(String userId, String projectId) {
        inviteRepository.save(Invite.builder().userId(userId).invitedToProjectId(projectId).build());
    }
}
