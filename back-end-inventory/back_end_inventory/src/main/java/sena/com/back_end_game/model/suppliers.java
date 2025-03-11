package sena.com.back_end_inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "suppliers")
public class suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String country;

    @Column(length = 20, nullable = false)
    private String phone;
}
