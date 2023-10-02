package com.ss_l3_e1.ss_l3_e1.config.security.filter;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ss_l3_e1.ss_l3_e1.config.security.authentication.CustomAuth;
import com.ss_l3_e1.ss_l3_e1.config.security.manenger.CusttomAuthManenger;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthFilter extends OncePerRequestFilter {

    private final CusttomAuthManenger custtomAuthManenger;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String key = String.valueOf(request.getHeader("key"));
        CustomAuth ca = new CustomAuth(false, key);

        var a = custtomAuthManenger.authenticate(ca);

        if (a.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response);
        }
    }

}
