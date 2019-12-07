package com.pms.projectmanagement.services.register;

import com.pms.projectmanagement.MailSenderService;
import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.models.User;
import com.pms.projectmanagement.repositories.UserRepository;
import com.pms.projectmanagement.services.register.RegisterService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final MailSenderService mailSenderService;
    @Override
    public void register(UserDto user) {
    User saveUser = modelMapper.map(user,User.class);
    saveUser.setId(UUID.randomUUID());
    saveUser.setActiveGuide(UUID.randomUUID().toString());
    mailSenderService.sendMail(saveUser.getEmail(),
            saveUser.getActiveGuide(),saveUser.getUserName());
    userRepository.save(saveUser);
    }
}
