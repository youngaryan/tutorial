package com.ss_l2_2.ss_l2_2.security;

import org.springframework.security.core.GrantedAuthority;

import com.ss_l2_2.ss_l2_2.entity.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }

}
