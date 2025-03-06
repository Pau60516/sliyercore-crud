package sena.com.back_end_game.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tournament")
public class tournament {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tournament_id")
    private int tournament_id;

    @Column(name = "team", length = 50, nullable = false)
    private String team;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "startDate", nullable = false)
    private Date startDate;

    @Column(name = "endDate", nullable = false)
    private Date endDate; 

    @Column(name = "prize", nullable = false)
    private Date prize; 

    
}
