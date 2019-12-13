package com.pms.projectmanagement.elasticsearch.service;

import com.pms.projectmanagement.elasticsearch.model.UserES;
import com.pms.projectmanagement.elasticsearch.repository.UserRepositoryES;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceESImpl implements UserServiceES {

    private final UserRepositoryES userRepository;

    @Override
    public UserES createNewUser(UserES user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserES> findAllByUsername(String username) {
        return userRepository.findAllByUsernameContaining(username);
    }
}
