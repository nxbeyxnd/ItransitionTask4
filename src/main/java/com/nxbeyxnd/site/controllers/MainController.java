package com.nxbeyxnd.site.controllers;

import com.nxbeyxnd.site.models.entities.User;
import com.nxbeyxnd.site.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("")
    @ResponseBody
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    //TODO add more response credentials and add to DB!
    @GetMapping("/user")
    public Map<String, String> user(@AuthenticationPrincipal OAuth2User principal) {
        User user = new User();
        Map<String, String> map = Collections.singletonMap("name", principal.getAttribute("name"));
        user.setId(map.get("name"));
        userService.saveOrUpdate(user);
        return map;
    }
}
