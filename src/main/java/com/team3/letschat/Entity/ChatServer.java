package com.team3.letschat.Entity;

import com.team3.letschat.Users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class ChatServer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serverName;
    @OneToOne
    private User Owner;
    @ManyToMany
    private Collection<User> userList = new ArrayList<>();
    @OneToMany
    private Collection<ChatRoom> chatRooms = new ArrayList<>();

    public ChatServer(String sname, User owner, Collection<User> userList, Collection<ChatRoom> chatRooms)
    {
        this.serverName = sname;
        this.Owner = owner;
        this.userList = userList;
        this.chatRooms = chatRooms;
    }
}
