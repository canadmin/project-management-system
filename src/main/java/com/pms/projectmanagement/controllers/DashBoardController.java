package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.elasticsearch.model.Notification;
import com.pms.projectmanagement.elasticsearch.service.notificationService.NotificationService;
import com.pms.projectmanagement.models.Project;
import com.pms.projectmanagement.services.dashboard.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"user","notifications"})
public class DashBoardController {

    private final DashBoardService dashBoardService;
    private final NotificationService notificationService;

    /**
     * kullanıcının bilgileri ve kullanıcının oluşturduğu ve dahil olduğu projeler dönmeli
     */
    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String getDashBoard(Model model, Principal principal){
        UserDto userDto = dashBoardService.getUserInfo(principal.getName());
        model.addAttribute("user",userDto);
        model.addAttribute("project",new ProjectDto());
        List<Notification> notifications = notificationService.showAllNotification(userDto.getId().toString());
        model.addAttribute("notifications",notifications);
        return "dashboard/dashboard";
    }
}
