package com.team3.letschat.DataFetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.team3.letschat.Entity.ChatServer;
import com.team3.letschat.Service.chatServerService;
import com.team3.letschat.Service.userService;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent @Slf4j
public class ChatServerDataFetcher {

    @Autowired
    private chatServerService chatserverservice;

    @Autowired
    private userService UserService;

    @DgsQuery
    public List<ChatServer> servers(String ServerName)
    {
        if(ServerName == null)
        {
            return this.chatserverservice.getAllServers();
        }
        else
        {
            return this.chatserverservice.getAllServers().stream().filter(s -> s.getServerName().contains(ServerName)).collect(Collectors.toList());
        }
    }

    @DgsMutation
    public void createNewChatServer(DataFetchingEnvironment dfe)
    {
        String ServerName = dfe.getArgument("ServerName");
        String OwnerName = dfe.getArgument("OwnerName");
        this.chatserverservice.createNewServer(new ChatServer(ServerName, OwnerName, new ArrayList<>(), new ArrayList<>()));
    }

}
