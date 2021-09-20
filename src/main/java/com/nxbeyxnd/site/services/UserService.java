package com.nxbeyxnd.site.services;

import com.nxbeyxnd.site.models.emuns.EnumUserStatuses;
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

    public String getCountBySocial(String social){
        return userDetailsRepository.countUsersBySocial(social);
    }

    public List<User> getAll(){
        return userDetailsRepository.findAll();
    }

    public User saveOrUpdate(User user){
        if (user.getStatus().equals(EnumUserStatuses.BANNED)){
            return new User();
        }
        if(user.getSocial().contains("google"))
            user.setSocial("Google");
        else if(user.getSocial().contains("github"))
            user.setSocial("GitHub");
        else if(user.getSocial().contains("facebook"))
            user.setSocial("Facebook");
        return userDetailsRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userDetailsRepository.findByEmail(email);
    }

    public void deleteAll(){
        userDetailsRepository.deleteAll();
    }

}
