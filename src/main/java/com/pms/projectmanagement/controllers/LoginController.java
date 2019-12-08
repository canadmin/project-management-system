package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.services.register.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class LoginController  {

    private final RegisterService registerService;

    @RequestMapping(value = {"/register"},method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user",new UserDto());
        model.addAttribute("showMessage",false);
        model.addAttribute("message","Please Verify your Email address");
        return "login/register";
    }

    @RequestMapping(value = {"/register"} ,method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") UserDto userDto, Model model){
        registerService.register(userDto);
        model.addAttribute("user",new UserDto());
        model.addAttribute("showMessage",true);
        return "login/register";
    }

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String login(Model model){
        return "login/login";
    }



}
