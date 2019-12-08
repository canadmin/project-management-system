package com.pms.projectmanagement.models;

import com.pms.projectmanagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseEntity{

    private int taskNumber;

    @ManyToOne
    private User signedUser;

    @ManyToOne
    private User openedUser;

    private Timestamp dueDate;

    @ManyToOne
    private Project project;

    private TaskStatus taskStatus;

    private boolean isSigned;
}
