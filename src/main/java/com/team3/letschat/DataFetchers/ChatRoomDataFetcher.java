package com.team3.letschat.DataFetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.team3.letschat.Entity.ChatRoom;
import com.team3.letschat.Service.chatRoomService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@DgsComponent
public class ChatRoomDataFetcher {

    @Autowired
    private chatRoomService chatroomservice;

    @DgsQuery
    public ChatRoom getChatroom(String roomname)
    {
        return chatroomservice.getChatRoom(roomname);
    }

    @DgsMutation
    public void createNewChatRoom(DataFetchingEnvironment dfe)
    {
       String server = dfe.getArgument("ServerName");
       String roomName = dfe.getArgument("RoomName");

       chatroomservice.createNewChatroom(server, new ChatRoom(roomName, new ArrayList<>()));
    }
}
