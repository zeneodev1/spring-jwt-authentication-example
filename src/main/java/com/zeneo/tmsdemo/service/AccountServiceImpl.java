package com.zeneo.tmsdemo.service;

import com.zeneo.tmsdemo.entity.Role;
import com.zeneo.tmsdemo.entity.User;
import com.zeneo.tmsdemo.repository.RoleRepository;
import com.zeneo.tmsdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public void DeleteUser(User user) {
        repository.deleteById(user.getId());
    }

    @Override
    public Role CreateRole(Role role) {
        return roleRepository.save(role);
    }
}
