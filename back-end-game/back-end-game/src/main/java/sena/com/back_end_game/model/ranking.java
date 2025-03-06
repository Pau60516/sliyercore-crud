package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="ranking")
public class ranking {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ranking_id")
    private int ranking_id;

    @ManyToOne
    @JoinColumn(name = "gamer_id", nullable = false)
    private gamer gamer;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "score", nullable = false)
    private int score;

}
