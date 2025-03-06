package sena.com.back_end_game.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="gamer")
public class gamer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gamer_id")
    private int gamer_id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "experience", nullable = false)
    private String experience;

    @Column(name = "registrationDate", nullable = false)
    private Date registrationDate;

    }
