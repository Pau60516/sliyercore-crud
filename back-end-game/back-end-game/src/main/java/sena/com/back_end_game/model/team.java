package sena.com.back_end_game.model;

import jakarta.persistence.GenerationType;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="team")
public class team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private int team_id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

}