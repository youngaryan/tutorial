package com.ss_l2_2.ss_l2_2.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss_l2_2.ss_l2_2.repo.UserRepo;
import com.ss_l2_2.ss_l2_2.security.SecurityUser;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JpaUserDetailsSerivice implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var u = userRepo.findByUsername(username);

        return u.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("no shuch a user with username : " + username));
    }

}
