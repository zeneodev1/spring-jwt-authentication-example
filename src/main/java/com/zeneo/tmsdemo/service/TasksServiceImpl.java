package com.zeneo.tmsdemo.service;

import com.zeneo.tmsdemo.entity.Task;
import com.zeneo.tmsdemo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TasksServiceImpl implements TasksService{

    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task getTaskById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return repository.save(task);
    }

    @Override
    public void removeTask(Task task) {
        repository.deleteById(task.getId());
    }
}
