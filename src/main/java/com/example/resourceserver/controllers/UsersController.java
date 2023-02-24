package com.example.resourceserver.controllers;

import com.example.resourceserver.response.UserRest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/status/check")
    public String status() {
        return "Working...";
    }

    @PreAuthorize("hasRole('developer')")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        return "Deleted user with id: " + id;
    }

    @PostAuthorize("returnObject.userId() == #id")
    @GetMapping("/{id}")
    public UserRest getUser(@PathVariable String id) {
        return new UserRest("test", "last", id);
    }
}
