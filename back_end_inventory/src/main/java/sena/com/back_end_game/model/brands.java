package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Brands")
public class brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", nullable = false)
    private int brand_id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "originCountry", length = 100)
    private String originCountry;

    public brands() {
    }

    public brands (int brand_id, String name, String originCountry){
        this.brand_id = brand_id;
        this.name = name;
        this.originCountry = originCountry;
     }

     public int getbrand_id() {
        return brand_id;
     }

     public void setbrand_id(int brand_id){
        this.brand_id=brand_id;
     }

    public String get_name() {
      return name;
     }
    
    public void set_name(String name){
         this.name=name;
     }

     public String get_originCountry() {
        return originCountry;
       }
      
      public void set_originCountry(String originCountry){
           this.originCountry=originCountry;
           
        }

}