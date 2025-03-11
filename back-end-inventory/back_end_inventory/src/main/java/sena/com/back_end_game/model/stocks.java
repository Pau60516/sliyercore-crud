package sena.com.back_end_game.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity(name = "stocks")
public class stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockID;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private products product; 

    @Column(nullable = false)
    private int quantity; 
}

