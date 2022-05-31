package com.team3.letschat.Service;

import com.team3.letschat.Users.User;
import com.team3.letschat.Users.UserRole;

import java.util.List;

public interface userService {

    User SaveUser(User user);
    UserRole SaveRole(UserRole role);
    void addRoleToUser(String username, String roleType);
    User getUser(String username);
    User EditUserInfo(String username);
    void removeUser(String username);
    UserRole editRole(String roleType);
    void removeRole(String roleType);
    List<User>getAllUsers();
}
