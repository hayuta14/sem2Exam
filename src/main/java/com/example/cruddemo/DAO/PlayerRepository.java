package com.example.cruddemo.DAO;

import com.example.cruddemo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
    @Query(value = "SELECT p.player_id,p.player_name,p.high_score,p.level,n.national_id,n.national_name FROM player p JOIN national n ON p.national_id = n.national_id;" ,nativeQuery = true)
    List<Player> showAllPlayer();
    @Query("SELECT p FROM Player p WHERE p.playerName = :playerName")
    List<Player> searchPlayerByName(@Param("playerName")String playerName);

    @Query("SELECT p FROM Player p ORDER BY p.highScore DESC")
    List<Player> top10Player();
}
