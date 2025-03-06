package sena.com.back_end_game.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="characters")
public class character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="character_id")
    private int character_id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "history", nullable = false)
    private String history;

    @Column(name = "ability1", nullable = false)
    private String ability1;

    @Column(name = "ability2", nullable = false)
    private String ability2;

    @Column(name = "ability3", nullable = false)
    private String ability3;

    @Column(name = "ability4", nullable = false)
    private String ability4;
    
}





