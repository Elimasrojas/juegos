
package com.g31mintic.Juegos.controller;

import com.g31mintic.Juegos.model.Game;
import com.g31mintic.Juegos.service.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Game")
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    //http://localhost:8085/api/Game/all
    @GetMapping("/all")
    public List<Game> getAll() {
        return gameService.getAllGame();
    }
    
    //http://localhost:8085/api/Game/save
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Game game){
        gameService.save(game);
        return ResponseEntity.status(201).build(); 
    }
}
