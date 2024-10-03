package com.example.cruddemo.entity;

import com.example.cruddemo.entity.National;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;



@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @ManyToOne
    @JoinColumn(name = "national_id", nullable = false)
    @JsonManagedReference // This side is the child
    private National national;

    @Column(name = "player_name", nullable = false, length = 100)
    private String playerName;

    @Column(name = "high_score", nullable = false)
    private Integer highScore;

    @Column(name = "level", nullable = false)
    private Integer level;

    // Default Constructor
    public Player() {
    }

    // Constructor
    public Player(National national, String playerName, Integer highScore, Integer level) {
        this.national = national;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
    }

    // Getters and Setters

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public National getNational() {
        return national;
    }

    public void setNational(National national) {
        this.national = national;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}