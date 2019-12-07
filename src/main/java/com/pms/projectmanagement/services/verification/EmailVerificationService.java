package com.pms.projectmanagement.services.verification;


import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmailVerificationService {
    Map<String,String> mailVerification(String activeGuide);

}
