package com.team3.letschat.Dao;

import com.team3.letschat.Entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chatRoomDAO extends JpaRepository<ChatRoom, Long> {
    ChatRoom findByRoomName(String RoomName);
}
