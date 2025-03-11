package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "reviews")
public class reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewID", nullable = false)
    private int review_id;

    @Column(name = "customerID", nullable = false)
    private int customerID;

    @Column(name = "productID", nullable = false)
    private int productID;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date", nullable = false)
    private java.util.Date date;
}

