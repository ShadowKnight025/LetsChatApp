package com.team3.letschat.Service;

import com.team3.letschat.Users.User;
import com.team3.letschat.Users.UserRole;

import java.util.List;

public interface userService {

    User SaveUser(User user);
    UserRole SaveRole(UserRole role);
    void addRoleToUser(String username, String roleType);
    User getUser(String username);
    User EditUserInfo(String username, User user);
    void removeUser(String username);
    UserRole editRole(String roleType, UserRole role);
    void removeRole(String roleType);
    List<User>getAllUsers();
    List<User>getFriendlist(String Username);
    void addFriendToFriendlist(String Username, String Friend);
    void removeFriendFromFriendlist(String Username, String Friend);
}
