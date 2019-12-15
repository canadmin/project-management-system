package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.dtos.ProjectDto;
import com.pms.projectmanagement.services.invite.InviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"projectInfo","user"})
public class InviteController {
    private final InviteService inviteService;

    @RequestMapping(value = "/inviteDeveloper",method = RequestMethod.POST)
    public String inviteDeveloper(@SessionAttribute("projectInfo") ProjectDto projectDto,
                                  Model model,
                                  @RequestParam(value = "userId",required = false) String userId){

        inviteService.inviteDeveloper(userId,projectDto.getId().toString());
        return "";
    }
}
