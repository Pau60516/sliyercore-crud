package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String country;

    @Column(length = 20, nullable = false)
    private String phone;

    public Suppliers (int supplier_id, String name, String country, String phone){
        this.supplier_id = supplier_id;
        this.name = name;
        this.country = country;
        this.phone = phone;
     }

     public int getsupplier_id() {
        return supplier_id;
     }

     public void setsupplier_id(int supplier_id){
        this.supplier_id=supplier_id;
     }

    public String get_name() {
      return name;
     }
    
    public void set_name(String name){
         this.name=name;
     }

     public String get_country() {
        return country;
       }
      
      public void set_country(String country){
           this.country=country;
      }

      public String get_phone() {
        return phone;
       }
      
      public void set_phone(String phone){
           this.phone=phone;
      }
}
