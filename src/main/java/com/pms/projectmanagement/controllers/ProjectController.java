package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.models.Project;
import com.pms.projectmanagement.services.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @RequestMapping(value = "/createProject/{userId}")
    public String createProject(@ModelAttribute("project") ProjectDto projectDto,
                                Model model,
                                @PathVariable UUID userId,
                                @ModelAttribute("user") UserDto userDto){
    projectService.createProject(projectDto,userId);
        return "redirect:/dashboard";
    }
}
