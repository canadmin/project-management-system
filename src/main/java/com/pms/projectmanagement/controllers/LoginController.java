package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController  {


    @RequestMapping(value = {"/register"},method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user",new User());
        return "login/register";
    }

    @RequestMapping(value = {"/register"} ,method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") User user, Model model){
        return "login/login";
    }

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String login(Model model){
        return "login/login";
    }

}
