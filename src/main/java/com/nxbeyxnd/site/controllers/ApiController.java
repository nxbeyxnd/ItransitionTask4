package com.nxbeyxnd.site.controllers;

import com.nxbeyxnd.site.models.entities.User;
import com.nxbeyxnd.site.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    private UserService userService;

    @GetMapping("/{social}")
    public String getCountBySocial(@PathVariable String social){
        return userService.getCountBySocial(social);
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }
}
