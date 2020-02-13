package com.pms.projectmanagement.elasticsearch.model;

import com.pms.projectmanagement.enums.NotificationType;
import com.pms.projectmanagement.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "pms", type = "notifications")
public class Notification {

    @Id
    private String id;
    private String senderName;
    private String receiverId;
    private String notificationMessage;
    private String projectId;
    private Boolean isRead;
    private NotificationType notificationType;
    private Boolean available;
}
