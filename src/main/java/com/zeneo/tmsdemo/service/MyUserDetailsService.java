package com.zeneo.tmsdemo.service;

import com.zeneo.tmsdemo.entity.User;
import com.zeneo.tmsdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User myUser = repository.findUserByUsername(s);
        return new org.springframework.security.core.userdetails.User(myUser.getUsername(),
                myUser.getPassword(), AuthorityUtils.createAuthorityList(myUser.getRole().getRoleName()));
    }

}
