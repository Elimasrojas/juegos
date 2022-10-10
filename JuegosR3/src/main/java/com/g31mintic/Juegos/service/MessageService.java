package com.g31mintic.Juegos.service;

import com.g31mintic.Juegos.model.Client;
import com.g31mintic.Juegos.model.Message;
import com.g31mintic.Juegos.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    }
    
    public Message save(Message message){
        if(message.getIdMessage() ==null){
            return messageRepository.save(message);
        }else{
             Optional<Message> e=messageRepository.findById(message.getIdMessage());
             if(e.isPresent()){
                 return e.get();
             }else{
                 return messageRepository.save(message);
             }
        }
    }
    
}
