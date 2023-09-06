package com.ss_l2_e1.ss_l2_e1.security;

import org.springframework.security.core.GrantedAuthority;

import com.ss_l2_e1.ss_l2_e1.entity.Authoritiy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthortie implements GrantedAuthority {

    private Authoritiy athority;

    @Override
    public String getAuthority() {
        return athority.getName();
    }

}
