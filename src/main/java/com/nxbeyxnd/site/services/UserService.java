package com.nxbeyxnd.site.services;

import com.nxbeyxnd.site.models.entities.User;
import com.nxbeyxnd.site.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public List<User> findAll(){
        return userDetailsRepository.findAll();
    }

    public User saveOrUpdate(User user){
        return userDetailsRepository.save(user);
    }

    public Optional<User> findById(String id){
        return userDetailsRepository.findById(id);
    }


}
