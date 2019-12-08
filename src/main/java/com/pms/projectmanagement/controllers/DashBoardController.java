package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.services.dashboard.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class DashBoardController {

    private final DashBoardService dashBoardService;

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String getDashBoard(Model model, Principal principal){
        System.out.println(principal.getName());
        UserDto userDto = dashBoardService.getUserInfo(principal.getName());
        model.addAttribute("user",userDto);
        return "main/dashboard";
    }
}
