package com.ss_l3_e1.ss_l3_e1.config.security.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.ss_l3_e1.ss_l3_e1.config.security.authentication.CustomAuth;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Value("${key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuth ca = (CustomAuth) authentication;

        String headerKey = ca.getKey();

        if (headerKey.equals(key)) {
            CustomAuth result = new CustomAuth(true, null);

            return result;
        }
        throw new BadCredentialsException("BadCredentialsException");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuth.class.equals(authentication);
    }

}
