package com.nxbeyxnd.site.models.dto;

import com.nxbeyxnd.site.models.emuns.EnumUserStatuses;
import com.nxbeyxnd.site.models.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String social;
    private LocalDateTime registerAt;
    private LocalDateTime visitedAt;
    private EnumUserStatuses status;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.social = user.getSocial();
        this.registerAt = user.getRegisterAt();
        this.visitedAt = user.getVisitedAt();
        this.status = user.getStatus();
    }
}
