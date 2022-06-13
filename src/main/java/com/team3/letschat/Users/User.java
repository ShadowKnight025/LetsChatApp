package com.team3.letschat.Users;

import com.team3.letschat.Entity.ChatServer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.util.annotation.Nullable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private String emailaddress;
    @ManyToMany @Nullable
    private Collection<UserRole> roles = new ArrayList();
    @ManyToMany @Nullable
    private Collection<ChatServer> servers = new ArrayList<>();

    public User(String username, String password, String emailaddress, Collection<UserRole> roles, Collection<ChatServer> servers)
    {
        this.username = username;
        this.password = password;
        this.emailaddress = emailaddress;
        this.roles = roles;
        this.servers = servers;
    }
}
