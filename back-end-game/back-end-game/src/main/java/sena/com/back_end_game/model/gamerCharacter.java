package sena.com.back_end_game.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "gamerCharacter")
public class gamerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "gamer_id", nullable = false)
    private gamer gamer;

    @ManyToOne
    @JoinColumn(name = "characters", nullable = false)
    private character characters;

}