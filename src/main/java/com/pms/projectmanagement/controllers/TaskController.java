package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.dtos.TaskDto;
import com.pms.projectmanagement.dtos.UserDto;
import com.pms.projectmanagement.services.project.ProjectService;
import com.pms.projectmanagement.services.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/task")
@SessionAttributes({"projectInfo","user"})
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;
    @RequestMapping("/createTask/{projectId}")
    public String createNewTask(@PathVariable UUID projectId,
                                @SessionAttribute("user")UserDto userDto,
                                @SessionAttribute("projectInfo")ProjectDto projectDto,
                                @ModelAttribute("task")TaskDto taskDto,
                                Model model,
                                @RequestParam(value = "username",required = false) String username){
        taskService.createNewTask(projectId,userDto.getId(),taskDto,username);
        ProjectDto newProjectDto = projectService.getProjectInfo(projectDto.getId());
        model.addAttribute("task",new TaskDto());
        model.addAttribute("projectInfo",newProjectDto);
        model.addAttribute("activeTab","dashboard");

        return "project/project";

    }

}
