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
    public void createNewChatroom(String ServerName, ChatRoom chatRoom)
    {
        ChatServer server = this.chatserverservice.getChatServer(ServerName);
        //Note: can change exception handling to allow for servers of the same name later
        if(server.getChatRooms().contains(chatRoom.getRoomName()) || server == null || chatRoom == null)
        {
           throw new RuntimeException("error: unable to add chatroom to server. Either chatroom already exist on Server or Server does not exist!");
        } else {
            this.chatroomdao.save(chatRoom);
            server.getChatRooms().add(chatRoom);
        }
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
    public void postChat(Long id, Chat chat) {
        ChatRoom room = this.chatroomdao.findById(id).get();
        this.chatservice.postMessage(chat);
        room.getChats().add(chat);
    }

    @Override
    public void deleteChat(Long id, Chat chat) {
        ChatRoom room = this.chatroomdao.findById(id).get();
        room.getChats().remove(chat);
        this.chatservice.deleteMessage(chat.getId());
    }

    @Override
    public void editChat(Chat chat) {
      chatservice.editMessage(chat);
    }
}
