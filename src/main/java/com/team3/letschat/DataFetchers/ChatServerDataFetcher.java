package com.team3.letschat.DataFetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.team3.letschat.Entity.ChatServer;
import com.team3.letschat.Service.chatServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent @Slf4j
public class ChatServerDataFetcher {

    @Autowired
    private chatServerService chatserverservice;

    @DgsQuery
    private List<ChatServer> servers(@InputArgument String serverName)
    {
        if(serverName != null)
        {
            return chatserverservice.getAllServers();
        }
        else
        {
            return chatserverservice.getAllServers().stream().filter(s -> s.getServerName().contains(serverName)).collect(Collectors.toList());
        }
    }
}
