package com.team3.letschat.Dao;

import com.team3.letschat.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
