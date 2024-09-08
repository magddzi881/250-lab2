package com.lab2.controller;

import com.lab2.component.PollManager;
import com.lab2.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    private final PollManager pollManager;

    public UserController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return pollManager.createUser(user);
    }

    @GetMapping
    public Collection<User> listUsers() {
        return pollManager.listUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return pollManager.getUserById(id);
    }

}
