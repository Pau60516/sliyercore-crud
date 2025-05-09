package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "products")
public class products {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "product_Id")
     private int product_Id;

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
     private String description;

     @Column(name = "price", nullable = false)
     private Double price;  // Campo para controlar la versión de cada fila

     public products() {
     }

     public products(int product_Id, brands brand, categories category, String name, String color, String description,
               Double price) {
          this.product_Id = product_Id;
          this.brand = brand;
          this.category = category;
          this.name = name;
          this.color = color;
          this.description = description;
          this.price = price;
     }

     public int getproduct_Id() {
          return product_Id;
     }

     public void setproduct_Id(int product_Id) {
          this.product_Id = product_Id;
     }

     public brands get_brand() {
          return brand;
     }

     public void set_brand(brands brand) {
          this.brand = brand;
     }

     public categories get_category() {
          return category;
     }

     public void set_category(categories category) {
          this.category = category;
     }

     public String get_name() {
          return name;
     }

     public void set_name(String name) {
          this.name = name;
     }

     public String get_color() {
          return color;
     }

     public void setcolor(String color) {
          this.color = color;
     }

     public String get_description() {
          return description;
     }

     public void set_description(String description) {
          this.description = description;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;

     }
}