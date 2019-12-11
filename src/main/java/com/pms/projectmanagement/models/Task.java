package com.pms.projectmanagement.models;

import com.pms.projectmanagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseEntity{

    private int taskNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User signedUser;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User openedUser;

    private Timestamp dueDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Project project;

    private TaskStatus taskStatus;

    private boolean isSigned;
}
