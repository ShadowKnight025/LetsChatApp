package com.team3.letschat.DataFetchers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.netflix.graphql.dgs.*;
import com.team3.letschat.Service.userService;
import com.team3.letschat.Users.User;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.OAuth2Token;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class UserDataFetcher {

    @Autowired
    private userService UserService;

    @DgsQuery
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

    @DgsMutation
    public User addUser(DataFetchingEnvironment dfe)
    {
        String username = dfe.getArgument("username");
        String password = dfe.getArgument("password");
        String emailaddress = dfe.getArgument("emailaddress");
        return UserService.SaveUser(new User(username, password, emailaddress, new ArrayList<>(), new ArrayList<>()));
    }


}
