package com.ss_l3_e1.ss_l3_e1.config.security.manenger;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.ss_l3_e1.ss_l3_e1.config.security.provider.CustomAuthProvider;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CusttomAuthManenger implements AuthenticationManager {

    private final CustomAuthProvider provider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (provider.supports(authentication.getClass())) {
            return provider.authenticate(authentication);
        }

        throw new BadCredentialsException("bad crid manenger");
    }

}
