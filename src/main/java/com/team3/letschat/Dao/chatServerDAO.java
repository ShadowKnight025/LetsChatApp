package com.team3.letschat.Dao;

import com.team3.letschat.Entity.ChatServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chatServerDAO extends JpaRepository<ChatServer, Long> {
    ChatServer findByServerName(String ServerName);
}
