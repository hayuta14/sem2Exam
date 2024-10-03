package com.example.cruddemo.controller;

import com.example.cruddemo.entity.Player;
import com.example.cruddemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService thePlayerService){
        playerService = thePlayerService;
    }



    @GetMapping("/name/{name}")
    public List<Player> getPlayerByName(@PathVariable("name") String name){
        return playerService.searchPlayerByName(name);
    }

    @GetMapping("/highscore")
    public List<Player> getTop10Player(){
        return playerService.top10Player();
    }

    @GetMapping("/allplayer")
    public List<Player> getAllPlayer(){
        return playerService.showAllPlayer();
    }
}
