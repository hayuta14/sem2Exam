package com.example.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "national")
public class National {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "national_id")
    private Integer nationalId;

    @Column(name = "national_name", nullable = false, length = 100)
    private String nationalName;

    @OneToMany(mappedBy = "national", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Player> players;

    public National(){}

    public National(String nationalName, List<Player> players) {
        this.nationalName = nationalName;
        this.players = players;
    }

    // Getters and Setters

    @Override
    public String toString() {
        return "National{" +
                "nationalId=" + nationalId +
                ", nationalName='" + nationalName + '\'' +
                ", players=" + players +
                '}';
    }

    public Integer getNationalId() {
        return nationalId;
    }

    public void setNationalId(Integer nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
