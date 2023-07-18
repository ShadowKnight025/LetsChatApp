package com.team3.letschat.Service;

import com.team3.letschat.Dao.RoleDAO;
import com.team3.letschat.Dao.UserDAO;
import com.team3.letschat.Users.User;
import com.team3.letschat.Users.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class userServiceImpl implements userService, UserDetailsService {

    @Autowired
    private UserDAO userdao;
    @Autowired
    private RoleDAO roledao;
    @Autowired
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User SaveUser(User user) {
        if (userdao.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("User already exist!");
        } else {
            log.info("Saving {} to the database with password {}", user.getUsername(), user.getPassword());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userdao.save(user);
            addRoleToUser(user.getUsername(), "ROLE_USER");
            return user;
        }
    }

    @Override
    public UserRole SaveRole(UserRole role) {
        log.info("Saving {} to the database", role.getRoleType());
        return this.roledao.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleType) {
        log.info("Adding role {} to user {}", roleType, username);
        User user = this.userdao.findByUsername(username);
        UserRole role = this.roledao.findByRoleType(roleType);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return this.userdao.findByUsername(username);
    }

    @Override
    public User EditUserInfo(String username, User updated_user) {
        log.info("Updating info for {} in database", username);
        User user = this.userdao.findByUsername(username);
        user.setUsername(updated_user.getUsername());
        user.setPassword(passwordEncoder.encode(updated_user.getPassword()));
        user.setEmailaddress(updated_user.getEmailaddress());
        return user;
    }

    @Override
    public void removeUser(String username) {
        log.info("Deleting user {} in database", username);
        User user = this.userdao.findByUsername(username);
        this.userdao.deleteById(user.getId());
    }

    @Override
    public UserRole editRole(String roleType, UserRole newRole) {
        UserRole role = this.roledao.findByRoleType(roleType);
        role.setRoleType(newRole.getRoleType());
        return role;
    }

    @Override
    public void removeRole(String roleType) {
        log.info("Deleting role {} from database", roleType);
        UserRole role = this.roledao.findByRoleType(roleType);
        this.roledao.deleteById(role.getId());
    }

    @Override
    public List<User> getAllUsers()
    {
        return this.userdao.findAll();
    }

    @Override
    public List<User> getFriendlist(String Username)
    {
        return this.userdao.findByUsername(Username).getFriendlist().stream().toList();
    }

    @Override
    public void addFriendToFriendlist(String Username, String Friend) {

        User thisUser = this.userdao.findByUsername(Username);
        User newFriend = this.userdao.findByUsername(Friend);

        if(thisUser.getFriendlist().contains(newFriend) || newFriend == null)
        {
            throw new RuntimeException("Error: unable to add { " + Friend + " } to friends list, check spelling and try again.");
        }
        else {
            thisUser.getFriendlist().add(newFriend);
            newFriend.getFriendlist().add(thisUser);
        }
    }

    @Override
    public void removeFriendFromFriendlist(String Username, String Friend) {

        User thisUser = this.userdao.findByUsername(Username);
        User FriendofUser = this.userdao.findByUsername(Friend);

        if(thisUser.getFriendlist().contains(FriendofUser))
        {
            thisUser.getFriendlist().remove(FriendofUser);
            FriendofUser.getFriendlist().remove(thisUser);
        } else {
            throw new RuntimeException("This person is not in your friends list!");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userdao.findByUsername(username);
        if(user == null)
        {
            log.error("user does not exist");
            throw new UsernameNotFoundException("User not found / does not exist");
        }
        else
        {
          log.info("User found: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleType())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
