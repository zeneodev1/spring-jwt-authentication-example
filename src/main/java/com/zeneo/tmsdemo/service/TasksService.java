package com.zeneo.tmsdemo.service;


import com.zeneo.tmsdemo.entity.Task;

import java.util.List;

public interface TasksService {
    List<Task> getAllTasks();
    Task getTaskById(Integer id);
    Task createTask(Task task);
    Task updateTask(Task task);
    void removeTask(Task task);
}
