package com.zeneo.tmsdemo.service;


import com.zeneo.tmsdemo.entity.Role;
import com.zeneo.tmsdemo.entity.User;

public interface AccountService {

    User createUser(User user);

    void DeleteUser(User user);

    Role CreateRole(Role role);

}
