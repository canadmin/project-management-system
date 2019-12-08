package com.pms.projectmanagement.services.dashboard;

import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.models.User;
import com.pms.projectmanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashBoardServiceImpl implements DashBoardService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    @Override
    public UserDto getUserInfo(String username) {
        User user = userRepository.findByUsername(username);
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }
}
