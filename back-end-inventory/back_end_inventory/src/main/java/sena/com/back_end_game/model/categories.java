package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private int category_id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;


    public Categories (int category_id, String name, String description){
        this.category_id = category_id;
        this.name = name;
        this.description = description;
     }

     public int getcategory_id() {
        return category_id;
     }

     public void setcategory_id(int category_id){
        this.category_id=category_id;
     }

    public String get_name() {
      return name;
     }
    
    public void set_name(String name){
         this.name=name;
     }

     public String get_description() {
        return description;
       }
      
      public void set_description(String description){
           this.description=description;
      }
}






