package com.team3.letschat.Dao;

import com.team3.letschat.Entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chatDAO extends JpaRepository<Chat, Integer> {

}
