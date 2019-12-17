package com.pms.projectmanagement.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity{

    private String projectName;

    private String projectDescription;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_developer",joinColumns = {@JoinColumn(name = "project_id")},
    inverseJoinColumns = {@JoinColumn(name = "developer_id")})
    private List<User> developers = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner" )
    private User owner;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private List<Task> tasks;

    private String githubRepoAddress;


}
