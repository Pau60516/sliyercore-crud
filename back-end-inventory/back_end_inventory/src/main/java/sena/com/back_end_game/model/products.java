package sena.com.back_end_game.model;

import java.time.format.TextStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name="Products")
public class Products {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int product_id;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brands brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categories category;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String color;
    
    @Column(name = "description", nullable = false)
    private TextStyle description;

    @Column(name = "price", nullable = false)
    private Number price;


public Products (int product_id, Brands brand, Categories category, String name, String color, TextStyle description, Number price ){
    this.product_id = product_id;
    this.brand = brand;
    this.category = category;
    this.name = name;
    this.color = color;
    this.description = description;
    this.price = price;
 }

 public int getproduct_id() {
    return product_id;
 }

 public void setproduct_id(int product_id){
    this.product_id=product_id;
 }

public Brands get_brand() {
  return brand;
 }

public void set_brand(Brands brand){
     this.brand=brand;
 }

 public Categories get_category() {
    return category;
   }
  
  public void set_category(Categories category){
       this.category=category;
  }

  public String get_name() {
    return name;
   }
  
  public void set_name(String name){
       this.name=name;
  }

  public String get_color() {
    return color;
   }
  
  public void setcolor(String color){
       this.color=color;
  }

  public TextStyle get_description() {
    return description;
   }
  
  public void setdescription(TextStyle description){
       this.description=description;
  }

}