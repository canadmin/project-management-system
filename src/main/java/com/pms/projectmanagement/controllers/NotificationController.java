package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.elasticsearch.model.Notification;
import com.pms.projectmanagement.elasticsearch.service.notificationService.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"projectInfo","user"})
public class NotificationController {

    private final NotificationService notificationService;

    @RequestMapping(value = "/showNotifications",method = RequestMethod.GET)
    public String showInvitation(@SessionAttribute("user") UserDto userDto,
                                 Model model){

        List<Notification> notifications = notificationService.showAllNotification(userDto.getId().toString());

        model.addAttribute("notification",notifications);

        return "project/notification/shownotifications";
    }

}
