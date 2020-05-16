package com.zeneo.tmsdemo.repository;

import com.zeneo.tmsdemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
