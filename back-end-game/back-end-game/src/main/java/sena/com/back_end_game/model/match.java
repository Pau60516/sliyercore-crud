package sena.com.back_end_game.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="matchs")
public class match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=" match_id")
    private int match_id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private event event;

    @Column(name = "date", length = 50, nullable = false)
    private Date date;

    @Column(name = "duration", nullable = false)
    private  Time duration;

    @Column(name = "gameMode", nullable = false)
    private String gameMode;
}
