package com.team3.letschat.Controller;

import com.team3.letschat.Entity.Chat;
import com.team3.letschat.Service.chatService;
import com.team3.letschat.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ChatController {

    @Autowired
    public chatService ChatService;

    @GetMapping("/")
    public String Welcome()
    {
        return "<html><h1> Welcome to Chat Application! </h1></html>";
    }

    @GetMapping("/getallchats")
    public List<Chat> getChats()
    {
        return ChatService.getMessages();
    }
    @GetMapping("/getsinglechat/{id}")
    public Chat getChat(@RequestParam int id)
    {
        return ChatService.getMessage(id);
    }

    @PostMapping("/post")
    public void postChat(@RequestBody Chat chat)
    {
        ChatService.postMessage(chat);
    }

}
