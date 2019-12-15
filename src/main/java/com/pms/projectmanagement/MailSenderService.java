package com.pms.projectmanagement;


import com.pms.projectmanagement.dtos.ProjectDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService {


    private JavaMailSender sender;

    public MailSenderService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendMail(String mail, String url, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail);
        message.setSubject("Verify");
        message.setText("Hello " + name.toLowerCase() + ", \n" +
                "Please Verify your email address \n" +
                "localhost:8080/verify/" + url);
        sender.send(message);
    }

    public void invite(String guestMail, ProjectDto projectDto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(guestMail);
        message.setSubject("Invite");
        message.setText("you are invited to"+ projectDto.getProjectName()+" project");
        sender.send(message);
    }
}
