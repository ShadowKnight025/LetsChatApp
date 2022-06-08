package com.team3.letschat.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @Slf4j @AllArgsConstructor @NoArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomName;
    @OneToMany
    private Collection<Chat> chats = new ArrayList<>();

    public ChatRoom(String roomName, Collection<Chat> chats)
    {
        this.roomName = roomName;
        this.chats = chats;
    }
}
