package com.nxbeyxnd.site.models.entities;

import com.nxbeyxnd.site.models.emuns.EnumUserStatuses;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "social")
    private String social;

    @Column(name = "register_at")
    private LocalDateTime registerAt;

    @Column(name = "visited_at")
    private LocalDateTime visitedAt;

    @Column(name = "user_status")
    private EnumUserStatuses status;
}
