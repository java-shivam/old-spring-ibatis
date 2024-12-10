package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws Exception {
        return userService.getUserById(id);
    }

    @GetMapping("/stored-procedure/{id}")
    public Map<String, Object> callStoredProcedure(@PathVariable int id) throws Exception {
        return userService.callStoredProcedure(id);
    }
}