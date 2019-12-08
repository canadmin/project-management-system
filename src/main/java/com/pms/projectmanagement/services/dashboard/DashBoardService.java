package com.pms.projectmanagement.services.dashboard;

import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.models.User;

public interface DashBoardService {

    UserDto getUserInfo(String username);
}
