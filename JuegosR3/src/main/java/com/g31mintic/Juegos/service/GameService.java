
package com.g31mintic.Juegos.service;

import com.g31mintic.Juegos.model.Game;
import com.g31mintic.Juegos.repository.GameRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    
    public List<Game> getAllGame(){
        return gameRepository.findAll();
    }
    
    public Game save(Game game){
        if(game.getId()==null){
            return gameRepository.save(game);
        }else{
             Optional<Game> e=gameRepository.findById(game.getId());
             if(e.isPresent()){
                 return e.get();
             }else{
                 return gameRepository.save(game);
             }
        }
    }
    /*
    public Optional<Game> getGame(Long id){
        return gameRepository.getGameById(id);
    }
    
    
    public Game update(Game game){
        if(game.getId()!=null){
            Optional<Game> q=gameRepository.getGameById(game.getId());
            if(q.isPresent()){
                if(game.getName()!=null){
                    q.get().setName(game.getName());
                }
            }
            if(q.isPresent()){
                if(game.getDeveloper()!=null){
                    q.get().setDeveloper(game.getDeveloper());
                }
            }
            if(q.isPresent()){
                if(game.getYear()!=null){
                    q.get().setYear(game.getYear());
                }
            }
            if(q.isPresent()){
                if(game.getCategory()!=null){
                    q.get().setCategory(game.getCategory());
                }
            }
            if(q.isPresent()){
                if(game.getDescription()!=null){
                    q.get().setDescription(game.getDescription());
                }
            }
            gameRepository.save(q.get());
            return q.get();
        }else{
            return game;
        }
    }
    public boolean delete(long id){
        boolean flag=false;
        
        Optional<Game> game=gameRepository.getGameById(id);
        if(game.isPresent()){
            gameRepository.delete(game.get());
            flag=true;
        }
        
        return flag;
    }
    
    
    */
}
