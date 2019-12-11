package com.pms.projectmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskComment extends BaseEntity{

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User signedUser;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Task task;

    private String comment;

    private String issueNumber;

    private UUID projectId;


}
