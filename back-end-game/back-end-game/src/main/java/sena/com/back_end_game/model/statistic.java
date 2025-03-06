package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="statistic")
public class statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="statistic_id")
    private int statistic_id;

    @ManyToOne
    @JoinColumn(name = "gamer_id", nullable = false)
    private gamer gamer;

    @Column(name = "kills", length = 50, nullable = false)
    private String kills;

    @Column(name = "deaths", nullable = false)
    private int deaths;

    @Column(name = "assist", nullable = false)
    private int assist;
    
}
