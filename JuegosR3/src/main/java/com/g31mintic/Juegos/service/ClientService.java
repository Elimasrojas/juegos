
package com.g31mintic.Juegos.service;

import com.g31mintic.Juegos.model.Category;
import com.g31mintic.Juegos.model.Client;
import com.g31mintic.Juegos.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
             Optional<Client> e=clientRepository.findById(client.getIdClient());
             if(e.isPresent()){
                 return e.get();
             }else{
                 return clientRepository.save(client);
             }
        }
    }
    
}
