package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "ordersProducts")
public class ordersProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private products product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitPrice", precision = 10, scale = 2)
    private double unitPrice;
}

