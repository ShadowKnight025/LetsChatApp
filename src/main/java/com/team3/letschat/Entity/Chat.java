package com.team3.letschat.Entity;

import com.team3.letschat.Users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.datetime.standard.DateTimeContext;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "chat_tbl") @Data @AllArgsConstructor @NoArgsConstructor
public class Chat {

    @Id
    @Column(name = "ChatID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;
    private String message;
    private Date date;

}
