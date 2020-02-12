package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.dtos.TaskDto;
import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.elasticsearch.model.UserES;
import com.pms.projectmanagement.elasticsearch.service.UserServiceES;
import com.pms.projectmanagement.elasticsearch.service.notificationService.NotificationService;
import com.pms.projectmanagement.services.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"projectInfo","user"})
public class ProjectController {

    private final ProjectService projectService;
    private final UserServiceES userServiceES;
    private final NotificationService notificationService;

    @RequestMapping(value = "/createProject/{userId}", method = RequestMethod.POST)
    public String createProject(@ModelAttribute("project") ProjectDto projectDto,
                                Model model,
                                @PathVariable UUID userId,
                                @SessionAttribute("user") UserDto userDto){
    projectService.createProject(projectDto,userId);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/showProject/{projectId}", method = RequestMethod.GET)
    public String showProject(Model model,
                              @PathVariable UUID projectId,
                              @SessionAttribute("user")UserDto userDto){

        ProjectDto projectDto = projectService.getProjectInfo(projectId);
        model.addAttribute("projectInfo",projectDto);
        model.addAttribute("user",userDto);
        model.addAttribute("task",new TaskDto());
        model.addAttribute("activeTab","dashboard");
        return "project/project";
    }

    @RequestMapping(value = "showProject/{projectId}/{tabName}")
    public String showProjectTab(Model model,
                                 @PathVariable UUID projectId,
                                 @PathVariable String tabName,
                                 @SessionAttribute("user")UserDto userDto,
                                 @SessionAttribute("projectInfo")ProjectDto projectDto){
        model.addAttribute("projectInfo",projectDto);
        model.addAttribute("user",userDto);
        model.addAttribute("task",new TaskDto());
        model.addAttribute("activeTab",tabName);
        return "project/project";
    }

    @RequestMapping(value = "/getAllDeveloper/{username}",method = RequestMethod.GET)
    public String searchDeveloper(@PathVariable String username,Model model){
        List<UserES> developers = userServiceES.findAllByUsername(username);
        model.addAttribute("developers",developers);
        return "project/developer/fragments/developerlist :: developerList";
    }

    @RequestMapping(value = "/inviteDeveloper",method = RequestMethod.POST)
    public String inviteDeveloper(@SessionAttribute("projectInfo") ProjectDto projectDto,
                                  @SessionAttribute("user") UserDto userDto,
                                  Model model,
                                  @RequestParam(value = "userId",required = false) String userId){

        notificationService.sendInviteNotification(userId,userDto.getFirstName(),projectDto); //send notifications (p to p)

        return "redirect:/dashboard";
    }

}
