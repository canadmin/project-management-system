package com.pms.projectmanagement.models.invite;

import com.pms.projectmanagement.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invite extends BaseEntity {

    private String invitedToProjectId;

    private String userId;

    private String inviteMessage;
}
