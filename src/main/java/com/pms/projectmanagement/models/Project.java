package com.pms.projectmanagement.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity{

    private String projectName;

    private String projectDescription;

  /*  @ManyToMany
    private List<User> developer;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner" )
    private User owner;

   // private List<Task> tasks;


}
