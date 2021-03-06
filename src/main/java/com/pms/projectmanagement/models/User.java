package com.pms.projectmanagement.models;

import com.fasterxml.jackson.annotation.*;
import com.pms.projectmanagement.enums.RoleType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String fullName;

    @Column(unique = true)
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String activeGuide;
    private Boolean isMailActive;

    @OneToMany(mappedBy = "owner",cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<Project> ownedProjects;

    @ManyToMany(mappedBy = "developers",cascade = CascadeType.ALL)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "signedUser",cascade = CascadeType.ALL)
    private List<Task> signedTasks;

    @OneToMany(mappedBy = "openedUser",cascade = CascadeType.ALL)
    private List<Task> openedTasks;

    @OneToMany(mappedBy = "signedUser")
    private List<TaskComment> taskComments;


}
