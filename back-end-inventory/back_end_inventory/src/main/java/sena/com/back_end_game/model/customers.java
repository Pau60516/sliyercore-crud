package sena.com.back_end_game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerID", nullable = false)
    private int customer_id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;


    public Customers (int customer_id, String name, String email, String address, String phone){
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
     }

     public int getcustomer_id() {
        return customer_id;
     }

     public void setcustomer_id(int customer_id){
        this.customer_id=customer_id;
     }

    public String get_name() {
      return name;
     }
    
    public void set_name(String name){
         this.name=name;
     }

     public String get_email() {
        return email;
       }
      
      public void set_email(String email){
           this.email=email;
      }

      public String get_address() {
        return address;
       }
      
      public void set_address(String address){
           this.address=address;
      }

      public String get_phone() {
        return phone;
       }
      
      public void set_phone(String phone){
           this.phone=phone;
      }


}

