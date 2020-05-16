package com.zeneo.tmsdemo.repository;

import com.zeneo.tmsdemo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
