package com.team3.letschat.Service;

import com.team3.letschat.Entity.Chat;
import com.team3.letschat.Entity.ChatRoom;

public interface chatRoomService {

    ChatRoom createNewChatroom(ChatRoom chatRoom);
    ChatRoom getChatRoom(String roomName);
    void editChatRoom(String roomName, String newRoomName);
    void deleteChatRoom(String roomName);
    void postChat(String roomName, Chat chat);
    void deleteChat(String roomName, Chat chat);
    void editChat(Chat chat);
}
