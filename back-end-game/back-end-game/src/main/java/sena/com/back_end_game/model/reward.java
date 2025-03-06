package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="reward")
public class reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reward_id")
    private int reward_id;

    @ManyToOne
    @JoinColumn(name = "gamer_id", nullable = false)
    private gamer gamer;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private gamer event;

    @Column(name = "tipe", length = 50, nullable = false)
    private String tipe;

    @Column(name = "value", nullable = false)
    private String value;
    
}
