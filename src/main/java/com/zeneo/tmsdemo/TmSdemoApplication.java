package com.zeneo.tmsdemo;

import com.zeneo.tmsdemo.entity.Role;
import com.zeneo.tmsdemo.entity.Task;
import com.zeneo.tmsdemo.entity.User;
import com.zeneo.tmsdemo.repository.RoleRepository;
import com.zeneo.tmsdemo.service.AccountService;
import com.zeneo.tmsdemo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TmSdemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TmSdemoApplication.class, args);
    }

    @Autowired
    private AccountService accountService;

    @Autowired
    private TasksService tasksService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        accountService.CreateRole(r1);
        accountService.CreateRole(r2);

        accountService.createUser(new User("admin1", passwordEncoder.encode("pass"), r1));
        accountService.createUser(new User("user1", passwordEncoder.encode("pass"), r2));

        tasksService.createTask(new Task("T1", "T1 content"));
        tasksService.createTask(new Task("T2", "T2 content"));
        tasksService.createTask(new Task("T3", "T3 content"));

    }
}
