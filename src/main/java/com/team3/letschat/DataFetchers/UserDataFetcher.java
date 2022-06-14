package com.team3.letschat.DataFetchers;

import com.netflix.graphql.dgs.*;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.team3.letschat.Service.userService;
import com.team3.letschat.Users.User;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.*;
import java.util.stream.Collectors;

@DgsComponent @Slf4j @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "false")
public class UserDataFetcher {

    @Autowired
    private userService UserService;

    @DgsQuery @Secured({"ROLE_ADMIN", "ROLE_DEVELOPER"})
    public List<User> users(String username)
    {
        if(username == null)
        {
            return UserService.getAllUsers();
        }
        else
        {
            return UserService.getAllUsers().stream().filter(u -> u.getUsername().contains(username)).collect(Collectors.toList());
        }
    }

    @DgsMutation @Secured("")
    public User addUser(DataFetchingEnvironment dfe)
    {
        String username = dfe.getArgument("username");
        String password = dfe.getArgument("password");
        String emailaddress = dfe.getArgument("emailaddress");
        return UserService.SaveUser(new User(username, password, emailaddress, new ArrayList<>(), new ArrayList<>()));
    }

    @DgsMutation @Secured("ROLE_USER")
    public void editUser(DataFetchingEnvironment dfe)
    {
        User oldUserData = UserService.getUser(dfe.getArgument("oldUsername"));
        String username = dfe.getArgument("username");
        String password = dfe.getArgument("password");
        String emailaddress = dfe.getArgument("emailaddress");
        UserService.EditUserInfo(oldUserData.getUsername(), new User(username, password, emailaddress, new ArrayList<>(), new ArrayList<>()));
    }

    @DgsMutation @Secured("ROLE_USER")
    public void deleteUser(DataFetchingEnvironment dfe)
    {
        UserService.removeUser(dfe.getArgument("username"));
    }
}
