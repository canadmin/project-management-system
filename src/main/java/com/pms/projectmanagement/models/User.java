package com.pms.projectmanagement.models;

import com.pms.projectmanagement.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID id;

    private String firstName;
    private String lastName;
    private String fullName;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authorities",joinColumns = {@JoinColumn(name = "username",referencedColumnName = "username")}
    ,inverseJoinColumns = {@JoinColumn(name = "role",referencedColumnName = "roleName")})*/
//    private List<Role> roles = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp registerDate;


    private String activeGuide;
    private Boolean isMailActive;
}
