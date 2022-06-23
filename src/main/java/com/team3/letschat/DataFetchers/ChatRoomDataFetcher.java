package com.team3.letschat.DataFetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.team3.letschat.Entity.Chat;
import com.team3.letschat.Entity.ChatRoom;
import com.team3.letschat.Service.chatRoomService;
import com.team3.letschat.Service.userService;
import com.team3.letschat.Users.User;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Instant;
import java.util.ArrayList;
import java.sql.Date;

@DgsComponent
public class ChatRoomDataFetcher {

    @Autowired
    private chatRoomService chatroomservice;

    @Autowired
    private userService UserService;

    @DgsQuery
    public ChatRoom getChatroom(String roomname)
    {
        return this.chatroomservice.getChatRoom(roomname);
    }

    @DgsMutation
    public void createNewChatRoom(DataFetchingEnvironment dfe)
    {
       String server = dfe.getArgument("ServerName");
       String roomName = dfe.getArgument("RoomName");
       this.chatroomservice.createNewChatroom(server, new ChatRoom(roomName, new ArrayList<>()));
    }

    @DgsMutation
    public void postChat(DataFetchingEnvironment dfe)
    {
        User sender = this.UserService.getUser(dfe.getArgument("sender"));
        Long id = Long.parseLong(dfe.getArgument("id"));
        String message = dfe.getArgument("message");
        Date date = new Date(System.currentTimeMillis()); /*ToDo: Refactor how Date is retrieved or remove */
        this.chatroomservice.postChat(id, new Chat(sender, message, date));
    }
}
