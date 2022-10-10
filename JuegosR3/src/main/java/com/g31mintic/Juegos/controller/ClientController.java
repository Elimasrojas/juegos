
package com.g31mintic.Juegos.controller;

import com.g31mintic.Juegos.model.Client;
import com.g31mintic.Juegos.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    //http://localhost:8084/api/Category/all
    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.getAllClient();
    }

    //http://localhost:8084/api/Category/save
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Client client) { 
        clientService.save(client);
        return ResponseEntity.status(201).build(); 
    }

    

    
}
