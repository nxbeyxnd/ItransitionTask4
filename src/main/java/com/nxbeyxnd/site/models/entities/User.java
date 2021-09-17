package com.nxbeyxnd.site.models.entities;

import com.nxbeyxnd.site.models.emuns.EnumUserStatuses;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private String id;

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
