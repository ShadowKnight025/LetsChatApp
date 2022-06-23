package com.team3.letschat.Service;

import com.team3.letschat.Entity.Chat;
import com.team3.letschat.Entity.ChatRoom;
import com.team3.letschat.Entity.ChatServer;

public interface chatRoomService {

    void createNewChatroom(String ServerName, ChatRoom chatRoom);
    ChatRoom getChatRoom(String roomName);
    void editChatRoom(String roomName, String newRoomName);
    void deleteChatRoom(String serverName, String roomName);
    void postChat(Long id, Chat chat);
    void deleteChat(Long id, Chat chat);
    void editChat(Chat chat);
}
