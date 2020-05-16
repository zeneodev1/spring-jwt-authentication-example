package com.zeneo.tmsdemo.controller;

import com.zeneo.tmsdemo.model.AuthenticationRequest;
import com.zeneo.tmsdemo.model.AuthenticationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        try {
            logger.info("authenticated");
            authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(token);
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("the username or password is wrong");
        }
        return new AuthenticationResponse((String.valueOf(token.getAuthorities().isEmpty()) ));
    }

}
