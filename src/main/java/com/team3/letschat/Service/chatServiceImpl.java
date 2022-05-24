package com.team3.letschat.Service;

import com.team3.letschat.Dao.chatDAO;
import com.team3.letschat.Entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class chatServiceImpl implements chatService{

    @Autowired
    private chatDAO chatDao;

    @Override
    public List<Chat> getMessages()
    {
        return this.chatDao.findAll();
    }

    @Override
    public Chat getMessage(int id)
    {
        Optional <Chat> c = this.chatDao.findById(id);
        Chat chat = null;
        if(c.isPresent())
        {
            chat = c.get();
        }
        else
        {
            throw new RuntimeException("message not found: " + id + " does not exist");
        }

        return chat;
    }

    @Override
    public void postMessage(Chat chat) {
         this.chatDao.save(chat);
    }

    @Override
    public void editMessage(Chat chat) {
         this.chatDao.save(chat);
    }

    @Override
    public void deleteMessage(int id) {
        this.chatDao.deleteById(id);
    }
}
