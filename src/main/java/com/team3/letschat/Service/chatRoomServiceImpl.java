package com.team3.letschat.Service;

import com.team3.letschat.Dao.chatRoomDAO;
import com.team3.letschat.Entity.Chat;
import com.team3.letschat.Entity.ChatRoom;
import com.team3.letschat.Entity.ChatServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class chatRoomServiceImpl implements chatRoomService {

    @Autowired
    private chatRoomDAO chatroomdao;

    @Autowired
    private chatServerService chatserverservice;

    @Autowired
    private chatService chatservice;

    @Override
    public ChatRoom createNewChatroom(String ServerName, ChatRoom chatRoom) {
        ChatServer server = this.chatserverservice.getChatServer(ServerName);
        server.getChatRooms().add(chatRoom);
        return this.chatroomdao.save(chatRoom);
    }

    @Override
    public ChatRoom getChatRoom(String roomName) {
        return this.chatroomdao.findByRoomName(roomName);
    }

    @Override
    public void editChatRoom(String roomName, String newRoomName) {
        ChatRoom updated = this.chatroomdao.findByRoomName(roomName);
        updated.setRoomName(newRoomName);
    }

    @Override
    public void deleteChatRoom(String serverName, String roomName) {
        ChatRoom delete = this.chatroomdao.findByRoomName(roomName);
        ChatServer server = chatserverservice.getChatServer(serverName);
        if (server.getChatRooms() != null) {
            server.getChatRooms().remove(this.chatroomdao.findByRoomName(roomName));
        }
        this.chatroomdao.deleteById(delete.getId());
    }

    @Override
    public void postChat(String roomName, Chat chat) {
        ChatRoom room = this.chatroomdao.findByRoomName(roomName);
        room.getChats().add(chat);
    }

    @Override
    public void deleteChat(String roomName, Chat chat) {
        ChatRoom room = this.chatroomdao.findByRoomName(roomName);
        room.getChats().remove(chat);
    }

    @Override
    public void editChat(Chat chat) {
      chatservice.editMessage(chat);
    }
}
