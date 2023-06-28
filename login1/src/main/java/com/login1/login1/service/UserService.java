package com.login1.login1.service;

import com.login1.login1.entity.UserEntity;
import com.login1.login1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(String userName, String password){
        userRepository.save(new UserEntity(userName,password));
    }

    public boolean checkLogIn(String userName, String password) {
        UserEntity userEntity = userRepository.findByEmail(userName);
        System.out.println(userEntity);
        if (userEntity != null) {
            return userEntity.getPassword().equals(password);
        }
        return false;
    }

}
