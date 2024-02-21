package com.ss_l3_e1.ss_l3_e1.config.security.authentication;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CustomAuth implements Authentication {

    private final boolean authenticate;
    private final String key;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;

    }

    @Override
    public Object getCredentials() {
        return null;

    }

    @Override
    public Object getDetails() {
        return null;

    }

    @Override
    public Object getPrincipal() {
        return null;

    }

    @Override
    public boolean isAuthenticated() {
        return authenticate;

    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

}