package com.nxbeyxnd.site.repositories;

import com.nxbeyxnd.site.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    String countUsersBySocial(String social);
}
