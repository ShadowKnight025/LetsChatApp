package com.team3.letschat.DataFetchers;

import com.netflix.graphql.dgs.*;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.team3.letschat.Service.userService;
import com.team3.letschat.Users.User;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.stream.Collectors;

@DgsComponent @Slf4j
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
