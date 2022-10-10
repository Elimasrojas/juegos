package com.g31mintic.Juegos.controller;

import com.g31mintic.Juegos.model.Message;
import com.g31mintic.Juegos.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //http://localhost:8084/api/Category/all
    @GetMapping("/all")
    public List<Message> getAllMessages(){
        return messageService.getAllMessage();
    }

    //http://localhost:8084/api/Category/save
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Message message) {
         messageService.save(message);
         return ResponseEntity.status(201).build();         
    }

}
