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

     public int getSupplier_Id() {
        return supplier_id;
     }

     public void setSupplier_Id(int supplier_id){
        this.supplier_id=supplier_id;
     }

    public String getName() {
      return name;
     }
    
    public void setName(String name){
         this.name=name;
     }

     public String getCountry() {
        return country;
       }
      
      public void setCountry(String country){
           this.country=country;
      }

      public String getPhone() {
        return phone;
       }
      
      public void setPhone(String phone){
           this.phone=phone;
      }
}
