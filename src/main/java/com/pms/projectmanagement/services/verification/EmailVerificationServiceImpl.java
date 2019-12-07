package com.pms.projectmanagement.services.verification;

import com.pms.projectmanagement.models.User;
import com.pms.projectmanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmailVerificationServiceImpl implements EmailVerificationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public Map<String,String> mailVerification(String activeGuide) {
        User user = userRepository.findByActiveGuide(activeGuide);
        Map<String,String> map= new HashMap<>();
        if(user == null){
            map.put("message","user not found");
            return map;
        }else{
            if(!user.getIsMailActive()){
                user.setIsMailActive(true);
                map.put("state","true");
                map.put("message","Email address successfully verified");
                userRepository.save(user);
                return map;
            }else{
                map.put("message","Account already verified");
                return map;
            }
        }
    }
}
