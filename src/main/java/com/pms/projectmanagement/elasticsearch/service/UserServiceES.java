package com.pms.projectmanagement.elasticsearch.service;

import com.pms.projectmanagement.elasticsearch.model.UserES;

import java.util.List;

public interface UserServiceES {
    UserES createNewUser(UserES user);

    List<UserES> findAllByUsername(String username);
}
