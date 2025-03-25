package sena.com.back_end_game.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "OrdersProducts")
public class OrdersProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderProduct_id", nullable = false)
    private int orderProduct_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitPrice", precision = 10, scale = 2)
    private double unitPrice;


    public OrdersProducts (int orderProduct_id, Orders order, Products product, int quantity, double unitPrice){
        this.orderProduct_id = orderProduct_id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
     }

     public int getorderProduct_id() {
        return orderProduct_id;
     }

     public void setorderProduct_id(int orderProduct_id){
        this.orderProduct_id=orderProduct_id;
     }

    public Orders get_order() {
      return order;
     }
    
    public void set_order(Orders order){
         this.order=order;
     }

     public Products get_product() {
        return product;
       }
      
      public void set_product(Products product){
           this.product=product;
      }

      public int get_quantity() {
        return quantity;
       }
      
      public void set_quantity(int quantity){
           this.quantity=quantity;
      }

      public double get_unitPrice() {
        return unitPrice;
       }
      
      public void setunitPrice(double unitPrice){
           this.unitPrice=unitPrice;
      }
    
}

