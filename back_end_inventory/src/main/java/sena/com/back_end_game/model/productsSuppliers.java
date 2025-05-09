package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity(name = "productssuppliers")
public class productsSuppliers {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "productsupplier_id", nullable = false)
   private int productsupplier_id;

   @ManyToOne
   @JoinColumn(name = "product_id", nullable = false)
   private products product;

   @ManyToOne
   @JoinColumn(name = "supplier_id", nullable = false)
   private suppliers supplier;

   public productsSuppliers() {
   }

   public productsSuppliers (int productsupplier_id, products product, suppliers supplier ){
        this.productsupplier_id = productsupplier_id;
        this.product = product;
        this.supplier = supplier;
   }

   public int getproductsupplier_id() {
      return productsupplier_id;
   }

   public void setproductsupplier_id(int productsupplier_id) {
      this.productsupplier_id = productsupplier_id;
   }

   public products get_product() {
      return product;
   }

   public void set_product(products product) {
      this.product = product;
   }

   public suppliers get_supplier() {
      return supplier;
   }

   public void set_supplier(suppliers supplier) {
      this.supplier = supplier;
   }
}
