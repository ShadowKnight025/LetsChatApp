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

    public Chat(){}

    public Chat(String message)
    {
        this.message = message;
    }

    public void setMessage(String msg)
    {
        this.message = msg;
    }

    public String getMessage()
    {
        return message;
    }

}
