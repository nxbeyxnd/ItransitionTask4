package com.nxbeyxnd.site.repositories;

import com.nxbeyxnd.site.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, String> {
}
