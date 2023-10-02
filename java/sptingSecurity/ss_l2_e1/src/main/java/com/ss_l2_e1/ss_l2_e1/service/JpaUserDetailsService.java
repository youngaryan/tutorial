package com.ss_l2_e1.ss_l2_e1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss_l2_e1.ss_l2_e1.repo.UserRepo;
import com.ss_l2_e1.ss_l2_e1.security.SecurityUser;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var u = userRepo.findByUsername(username);

        return u.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("username not found: " + username));

    }

}
