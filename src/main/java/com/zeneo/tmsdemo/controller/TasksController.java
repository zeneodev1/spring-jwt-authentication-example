package com.zeneo.tmsdemo.controller;

import com.zeneo.tmsdemo.entity.Task;
import com.zeneo.tmsdemo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return tasksService.getAllTasks();
    }

}
