package com.pms.projectmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID id;

    private String firstName;
    private String lastName;
    private String fullName;

    private String username;
    private String email;
    private String password;

    private String roleType;

    private Boolean isMailActive = false;

}
