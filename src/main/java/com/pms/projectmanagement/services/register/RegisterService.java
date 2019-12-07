package com.pms.projectmanagement.services.register;

import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.models.User;

public interface RegisterService {

    void register(UserDto user);

}
