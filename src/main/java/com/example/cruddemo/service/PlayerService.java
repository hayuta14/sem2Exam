package com.example.cruddemo.service;

import com.example.cruddemo.DAO.PlayerRepository;
import com.example.cruddemo.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    public PlayerService(PlayerRepository thePlayerRepository){
        playerRepository=thePlayerRepository;
    }
    // Using method query creation
    public List<Player> searchPlayerByName(String name) {
        return playerRepository.searchPlayerByName(name);
    }

    // Using method query for score greater than
    public List<Player> showAllPlayer() {
        return playerRepository.showAllPlayer();
    }
    public List<Player> top10Player() {
        return playerRepository.top10Player();
    }
}
