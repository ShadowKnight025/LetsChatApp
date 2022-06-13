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

    @Override
    public void createNewServer(ChatServer chatServer)
    {
        if (chatServer.getUserList() != null) {
            chatServer.getUserList().add(this.userservice.getUser(chatServer.getOwner()));
        }
        log.info("Saved to DB {}", chatServer.getServerName());
        this.chatserverdao.save(chatServer);
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

    public void changeServerOwner(String serverName, String newOwner)
    {
        if(newOwner != null && this.userservice.getUser(newOwner) != null)
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
        server.getUserList().add(this.userservice.getUser(username));
    }

    @Override
    public void removeUser(String serverName, String username)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        server.getUserList().remove(this.userservice.getUser(username));
    }


    //Creating & Deleting Chatrooms will be handled by the ChatRoom Service.
  /* @Override
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
    } */

    @Override
    public List<User> getUserList(String serverName)
    {
        ChatServer server = this.chatserverdao.findByServerName(serverName);
        return server.getUserList().stream().toList();
    }
}
