package sena.com.back_end_game.model;

import jakarta.persistence.*;

@Entity(name = "orders")
public class orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID", nullable = false)
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private customers customer;

    @Column(name = "date")
    private java.time.LocalDateTime date;

    @Column(name = "total", precision = 10, scale = 2)
    private double total;

    @Column(name = "status", nullable = false)
    private String status;
}
