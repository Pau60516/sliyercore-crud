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
   @Column(name = "stock_id", nullable = false)
   private int stock_id;

   @ManyToOne
   @JoinColumn(name = "product_id", nullable = false)
   private products product;

   @Column(name = "quantity", nullable = false)
   private int quantity;

   public stocks() {
   }

   // Constructor with parameter
   public stocks(int stock_id, products product, int quantity) {
      this.stock_id = stock_id;
      this.product = product;
      this.quantity = quantity;
   }

   public int getstock_id() {
      return stock_id;
   }

   public void setstock_id(int stock_id) {
      this.stock_id = stock_id;
   }

   public products get_product() {
      return product;
   }

   public void set_product(products product) {
      this.product = product;
   }

   public int get_quantity() {
      return quantity;
   }

   public void set_quantity(int quantity) {
      this.quantity = quantity;
   }

}
