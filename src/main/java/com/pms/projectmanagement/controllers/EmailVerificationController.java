package com.pms.projectmanagement.controllers;

import com.pms.projectmanagement.services.verification.EmailVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/verify/")
@AllArgsConstructor
public class EmailVerificationController {

    private final EmailVerificationService emailVerificationService;

    @RequestMapping("{activeGuide}")
    public String verifyEmail(@PathVariable String activeGuide, Model model){
    Map<String ,String > response = emailVerificationService.mailVerification(activeGuide);
        model.addAttribute("response",response);
        return "redirect:/login";
    }
}
