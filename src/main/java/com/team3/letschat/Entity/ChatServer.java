package com.team3.letschat.Entity;

import com.team3.letschat.Users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.util.annotation.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class ChatServer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String serverName;
    private String Owner;
    @ManyToMany @Nullable
    private Collection<User> userList = new ArrayList<>();
    @OneToMany @Nullable
    private Collection<ChatRoom> chatRooms = new ArrayList<>();

    public ChatServer(String serverName, String owner, Collection<User> userList, Collection<ChatRoom> chatRooms)
    {
        this.serverName = serverName;
        this.Owner = owner;
        this.userList = userList;
        this.chatRooms = chatRooms;
    }
}
