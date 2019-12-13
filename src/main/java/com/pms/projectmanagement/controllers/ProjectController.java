package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.dtos.TaskDto;
import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.services.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"projectInfo","user"})
public class ProjectController {

    private final ProjectService projectService;

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
}
