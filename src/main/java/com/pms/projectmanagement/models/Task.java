package com.pms.projectmanagement.models;

import com.pms.projectmanagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Project project;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;

    @OneToMany(mappedBy = "task")
    private List<TaskComment> taskComments;

    private boolean isSigned;

    private String taskDescription;
    private String taskTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

}
