package sena.com.back_end_game.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "orders")
public class orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private customers customer;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "status", nullable = false)
    private String status;

     public orders() {
     }

    public orders (int order_id, customers customer, LocalDateTime date, BigDecimal total, String status){
        this.order_id = order_id;
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.status = status;
     }

     public int getorder_id() {
        return order_id;
     }

     public void setorder_id(int order_id){
        this.order_id=order_id;
     }

    public customers get_customer() {
      return customer;
     }
    
    public void set_customer(customers customer){
         this.customer=customer;
     }

     public LocalDateTime get_date() {
        return date;
       }
      
      public void set_date(LocalDateTime date){
           this.date=date;
      }

      public BigDecimal get_total() {
        return total;
       }
      
      public void set_total(BigDecimal total){
           this.total=total;
      }

      public String get_status() {
        return status;
       }
      
      public void set_phone(String status){
           this.status=status;
      }

}
