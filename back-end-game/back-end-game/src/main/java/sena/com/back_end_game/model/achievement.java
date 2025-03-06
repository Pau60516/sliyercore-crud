package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "achivement")
public class achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="achievement_id")
    private int achievement_id;

    @ManyToOne
    @JoinColumn(name = "gamer_id", nullable = false)
    private gamer gamer;

    @ManyToOne
    @JoinColumn(name = "reward_id", nullable = false)
    private reward reward;

    @Column(name = "dateObtained", length = 50, nullable = false)
    private String dateObtained;

    @Column(name = "description", nullable = false)
    private String description;

}
