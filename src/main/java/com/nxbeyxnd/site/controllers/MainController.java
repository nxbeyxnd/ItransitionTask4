package com.nxbeyxnd.site.controllers;

import com.nxbeyxnd.site.models.dto.SocialCounterDto;
import com.nxbeyxnd.site.models.dto.UserDto;
import com.nxbeyxnd.site.models.emuns.EnumUserStatuses;
import com.nxbeyxnd.site.models.entities.User;
import com.nxbeyxnd.site.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto showUserPage(@AuthenticationPrincipal OAuth2User principal) {
        User user = new User();
        Map<String, Object> map = principal.getAttributes();
        userService.findByEmail(map.get("email").toString()).orElseGet(()->{
            user.setEmail(map.get("email").toString());
            user.setName(map.get("name").toString());
            user.setStatus(EnumUserStatuses.VALID);
            user.setRegisterAt(LocalDateTime.now());
            user.setVisitedAt(LocalDateTime.now());
            user.setSocial(principal.getAttributes().toString());
            userService.saveOrUpdate(user);
            return user;
        });
        user.setVisitedAt(LocalDateTime.now());
        return new UserDto(user);
    }

    @GetMapping("/del")
    public void deleteAll(){
        userService.deleteAll();
    }
}
