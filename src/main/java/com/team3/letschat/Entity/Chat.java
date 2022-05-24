package com.team3.letschat.Entity;

import com.team3.letschat.Users.User;
import javax.persistence.*;

@Entity
@Table(name = "chat_tbl")
public class Chat {

    @Id
    @Column(name = "ChatID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
    private User user;

    public Chat(){}

    public Chat(String message, User user)
    {
        this.message = message;
        this.user = user;
    }

    public void setMessage(String msg)
    {
        this.message = msg;
    }

    public String getMessage()
    {
        return message;
    }

    public User getUser()
    {
        return user;
    }


}
