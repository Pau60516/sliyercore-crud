package sena.com.back_end_game.model;

import java.time.format.TextStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name="products")
public class products {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int product_id;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private brands brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private categories category;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String color;
    
    @Column(name = "description", nullable = false)
    private TextStyle description;

    @Column(name = "price", nullable = false)
    private Number price;

}
