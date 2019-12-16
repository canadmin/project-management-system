package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.elasticsearch.model.Notification;
import com.pms.projectmanagement.services.notificationService.NotificationService;
import com.pms.projectmanagement.services.invite.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"projectInfo","user"})
public class InvitationController {

    private final InvitationService inviteService;
    private final NotificationService notificationService;

    @RequestMapping(value = "/inviteDeveloper",method = RequestMethod.POST)
    public String inviteDeveloper(@SessionAttribute("projectInfo") ProjectDto projectDto,
                                  @SessionAttribute("user") UserDto userDto,
                                  Model model,
                                  @RequestParam(value = "userId",required = false) String userId){

        inviteService.inviteDeveloper(userId,projectDto.getId().toString());
        notificationService.sendInviteNotification(userId,userDto.getFirstName(),projectDto);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/showInvitation",method = RequestMethod.GET)
    public String showInvitation(@SessionAttribute("user") UserDto userDto,
                                 Model model){

        List<Notification> notifications = notificationService.showAllNotification(userDto.getId().toString());

        model.addAttribute("notification",notifications);

        return "project/invitation/showInvitations";
    }

}
