package com.pms.projectmanagement.repositories.invite;

import com.pms.projectmanagement.models.invite.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InviteRepository extends JpaRepository<Invitation, UUID> {
    Invitation findByUserId(String userId);
}
