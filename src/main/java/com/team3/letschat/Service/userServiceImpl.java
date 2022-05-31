package com.team3.letschat.Service;

import com.team3.letschat.Dao.RoleDAO;
import com.team3.letschat.Dao.UserDAO;
import com.team3.letschat.Users.User;
import com.team3.letschat.Users.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class userServiceImpl implements userService {
    private UserDAO userdao;
    private RoleDAO roledao;

    @Override
    public User SaveUser(User user)
    {
        log.info("Saving {} to the database", user.getUsername());
        return this.userdao.save(user);
    }

    @Override
    public UserRole SaveRole(UserRole role)
    {
        log.info("Saving {} to the database", role.getRoleType());
        return this.roledao.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleType)
    {
        log.info("Adding role {} to user {}", roleType, username);
        User user = userdao.findByUsername(username);
        UserRole role = roledao.findByRoleType(roleType);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username)
    {
        return this.userdao.findByUsername(username);
    }

    @Override
    public User EditUserInfo(String username)
    {
        log.info("Updating info for {} in database", username);
        User user = userdao.findByUsername(username);
        return user;
    }

    @Override
    public void removeUser(String username)
    {
        log.info("Deleting user {} in database", username);
        User user = this.userdao.findByUsername(username);
        this.userdao.deleteById(user.getId());
    }

    @Override
    public UserRole editRole(String roleType)
    {
        UserRole role = roledao.findByRoleType(roleType);
        return role;
    }

    @Override
    public void removeRole(String roleType)
    {
        log.info("Deleting role {} from database", roleType);
        UserRole role = roledao.findByRoleType(roleType);
        roledao.deleteById(role.getId());
    }

    @Override
    public List<User> getAllUsers()
    {
        return userdao.findAll();
    }
}
