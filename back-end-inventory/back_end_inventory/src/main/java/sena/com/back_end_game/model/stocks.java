package sena.com.back_end_game.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity(name = "Stocks")
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stock_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product; 

    @Column(nullable = false)
    private int quantity; 

    public Stocks (int stock_id, Products product, int quantity){
        this.stock_id = stock_id;
        this.product = product;
        this.quantity = quantity;
     }

     public int getstock_id() {
        return stock_id;
     }

     public void setstock_id(int stock_id){
        this.stock_id=stock_id;
     }

    public Products get_product() {
      return product;
     }
    
    public void set_product(Products product){
         this.product=product;
     }

     public int get_quantity() {
        return quantity;
       }
      
      public void set_quantity(int quantity){
           this.quantity=quantity;
      }

}

