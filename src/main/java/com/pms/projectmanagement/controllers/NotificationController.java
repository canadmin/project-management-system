package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.elasticsearch.model.Notification;
import com.pms.projectmanagement.elasticsearch.service.notificationService.NotificationService;
import com.pms.projectmanagement.services.invitation.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"projectInfo","user"})
public class NotificationController {

    private final NotificationService notificationService;
    private final InvitationService invitationService;

    @RequestMapping(value = "/showNotifications",method = RequestMethod.GET)
    public String showInvitation(@SessionAttribute("user") UserDto userDto,
                                 Model model){

        List<Notification> notifications = notificationService.showAllNotification(userDto.getId().toString());

        model.addAttribute("notification",notifications);

        return "project/notification/shownotifications";
    }
    @RequestMapping(value = "/acceptInvitation/{projectId}",method = RequestMethod.POST)
    public String acceptInvitation(@SessionAttribute("user") UserDto userDto,
                                   Model model,
                                   @PathVariable String projectId,
                                   @RequestParam(value = "id",required = true) String id,
                                   @RequestParam(value = "receiverId",required = true) String receiverId){
        ProjectDto projectDto = invitationService.joinProject(projectId,receiverId,id);

        return "redirect:/showProject/"+projectDto.getId().toString();

    }

}
