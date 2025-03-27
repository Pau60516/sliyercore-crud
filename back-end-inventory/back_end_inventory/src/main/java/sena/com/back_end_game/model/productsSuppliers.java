package sena.com.back_end_game.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity(name = "ProductsSuppliers")
public class ProductsSuppliers {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int productSupplier_id;

   @ManyToOne
   @JoinColumn(name = "product_id", nullable = false)
   private Products product;

   @ManyToOne
   @JoinColumn(name = "supplier_id", nullable = false)
   private Suppliers supplier;


   public ProductsSuppliers (int productSupplier_id, Products product, Suppliers supplier ){
        this.productSupplier_id = productSupplier_id;
        this.product = product;
        this.supplier = supplier;
   }

   public int getproductSupplier_id() {
      return productSupplier_id;
   }

   public void setproductSupplier_id(int productSupplier_id) {
      this.productSupplier_id = productSupplier_id;
   }

   public Products get_product() {
      return product;
   }

   public void set_product(Products product) {
      this.product = product;
   }

   public Suppliers get_supplier() {
      return supplier;
   }

   public void set_supplier(Suppliers supplier) {
      this.supplier = supplier;
   }
}
