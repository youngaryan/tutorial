package com.login1.login1.service;

import com.login1.login1.entity.UserEntity;
import com.login1.login1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserRepository userRepository;

    public void register(String userName, String password){
        userRepository.save(new UserEntity(userName,password));
    }


    //checking user login details
    public boolean checkLogIn(String userName, String password) {
        UserEntity userEntity = userRepository.findByEmail(userName);
        if (userEntity != null) {
            return userEntity.getPassword().equals(password);
        }
        return false;
    }


    //sending email for resetting passwords
    @Transactional
    public void setJavaMailSender(String emailSendTo)  {
        if (userRepository.existsByEmail(emailSendTo)){
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            Random random = new Random();
            UserEntity user = userRepository.findByEmail(emailSendTo);
            String r = String.valueOf(random.nextInt(100000));
            user.setPin(r);
            simpleMailMessage.setFrom("aryangolbaghi@gmail.com");
            simpleMailMessage.setSubject("Authentication");
            simpleMailMessage.setTo(emailSendTo);
            simpleMailMessage.setText("input the following code "+r+" expires in 1 min");
            javaMailSender.send(simpleMailMessage);
        }
    }

    //find User by their email
    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    //find user by their pin
    public UserEntity findByPin(String pin){return userRepository.findByPin(pin);}

    //boolean existByPin
    public boolean existByPin(String pin){return userRepository.existsByPin(pin);}

}
