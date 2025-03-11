package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "brands")
public class brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandID", nullable = false)
    private int brand_id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "originCountry", length = 100)
    private String originCountry;
}
