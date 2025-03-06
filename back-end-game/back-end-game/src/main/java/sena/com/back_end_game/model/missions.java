package sena.com.back_end_game.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="missions")
public class missions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mission_id")
    private int mission_id;

    @Column(name = "gamer_id", length = 50, nullable = false)
    private String gamer_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "reward", nullable = false)
    private String reward;

}