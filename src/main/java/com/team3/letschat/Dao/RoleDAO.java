package com.team3.letschat.Dao;

import com.team3.letschat.Users.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<UserRole, Long> {
    UserRole findByRoleType(String roleType);
}
