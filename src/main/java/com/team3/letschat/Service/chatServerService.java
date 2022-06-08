package com.team3.letschat.Service;

import com.team3.letschat.Entity.ChatRoom;
import com.team3.letschat.Entity.ChatServer;
import com.team3.letschat.Users.User;

import java.util.Collection;
import java.util.List;

public interface chatServerService {

    ChatServer createNewServer(ChatServer chatServer);
    ChatServer getChatServer(String serverName);
    void editChatServer(String serverName, String newServerName);
    void changeServerOwner(String serverName, User newOwner);
    void deleteChatServer(String serverName);
    List<ChatServer> getAllServers();
    void addUser(String serverName, String username);
    void removeUser(String serverName, String username);
    void addChatRoom(String serverName, String chatRoomName);
    void removeChatRoom(String serverName, String roomName);
    List<ChatRoom> getChatRooms(String serverName);
    List<User> getUserList(String serverName);

}
