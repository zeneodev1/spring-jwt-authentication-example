package com.zeneo.tmsdemo.repository;

import com.zeneo.tmsdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String userName);

}
