package com.team3.letschat.Service;

import com.team3.letschat.Entity.Chat;

import java.util.List;

public interface chatService {

    List<Chat> getMessages();
    Chat getMessage(int id);
    void postMessage(Chat chat);
    void editMessage(Chat chat);
    void deleteMessage(int id);
}
