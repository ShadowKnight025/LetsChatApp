package com.team3.letschat.Service;

import com.team3.letschat.Dao.chatServerDAO;
import com.team3.letschat.Entity.ChatRoom;
import com.team3.letschat.Entity.ChatServer;
import com.team3.letschat.Users.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class chatServerServiceImpl implements chatServerService{

    @Autowired
    private chatServerDAO chatserverdao;
    @Autowired
    private userService userservice;
    @Autowired
    private chatRoomService chatroomservice;

    @Override
    public ChatServer createNewServer(ChatServer chatServer) {
        return this.chatserverdao.save(chatServer);
    }

    @Override
    public ChatServer getChatServer(String serverName) {
        return this.chatserverdao.findByServerName(serverName);
    }

    @Override
    public void editChatServer(String serverName, String newServerName) {
        ChatServer updated = this.chatserverdao.findByServerName(serverName);
        updated.setServerName(newServerName);
    }

    public void changeServerOwner(String serverName, User newOwner)
    {
        if(newOwner != null && userservice.getUser(newOwner.getUsername()) != null)
        {
            ChatServer server = this.chatserverdao.findByServerName(serverName);
            server.setOwner(newOwner);
        }
    }

    @Override
    public void deleteChatServer(String serverName)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        this.chatserverdao.deleteById(server.getId());
    }

    @Override
    public List<ChatServer> getAllServers()
    {
        return this.chatserverdao.findAll();
    }

    @Override
    public List<ChatRoom> getChatRooms(String serverName)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        return server.getChatRooms().stream().toList();
    }

    @Override
    public void addUser(String serverName, String username)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        server.getUserList().add(userservice.getUser(username));
    }

    @Override
    public void removeUser(String serverName, String username)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        server.getUserList().remove(userservice.getUser(username));
    }

    @Override
    public void addChatRoom(String serverName, String chatRoomName)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        server.getChatRooms().add(chatroomservice.getChatRoom(chatRoomName));
    }

    @Override
    public void removeChatRoom(String serverName, String chatRoomName)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        server.getChatRooms().remove(chatroomservice.getChatRoom(chatRoomName));
    }

    @Override
    public List<User> getUserList(String serverName)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        return server.getUserList().stream().toList();
    }
}
