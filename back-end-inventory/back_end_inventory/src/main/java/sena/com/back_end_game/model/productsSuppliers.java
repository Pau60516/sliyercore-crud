package sena.com.back_end_game.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity(name = "products_suppliers")
public class productsSuppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productSupplier_id;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private products product; 

    @ManyToOne
    @JoinColumn(name = "supplierID", nullable = false)
    private suppliers supplier; 
}
