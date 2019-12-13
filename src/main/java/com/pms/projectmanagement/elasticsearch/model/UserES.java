package com.pms.projectmanagement.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.IdClass;
import java.util.UUID;

@Document(indexName = "pms", type = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserES {

    @Id
    private String id;
    private String username;

}
