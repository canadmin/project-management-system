package com.pms.projectmanagement.elasticsearch.repository.notification;

import com.pms.projectmanagement.elasticsearch.model.Notification;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends ElasticsearchRepository<Notification, String> {

    List<Notification> findAllByReceiverId(String receiverId);
}
