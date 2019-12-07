package com.pms.projectmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService {


    private  JavaMailSender sender;

    public MailSenderService(JavaMailSender sender) {
        this.sender = sender;
    }

    public  void sendMail(String mail, String url, String name){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(mail);
            message.setSubject("Verify");
            message.setText("Hello "+name.toLowerCase()+", \n"+
                    "Please Verify your email address \n"+
                    "localhost:8080/verify/verifyAccount/"+url);
            sender.send(message);
    }
}
