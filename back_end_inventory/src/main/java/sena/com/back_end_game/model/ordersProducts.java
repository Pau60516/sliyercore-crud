package sena.com.back_end_game.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "ordersProducts")
public class ordersProducts {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "orderProduct_id", nullable = false)
     private int orderProduct_id;

     @ManyToOne
     @JoinColumn(name = "order_id", nullable = false)
     private orders order;

     @ManyToOne
     @JoinColumn(name = "product_id", nullable = false)
     private products product;

     @Column(name = "quantity")
     private int quantity;

     @Column(name = "unitPrice", precision = 10, scale = 2)
     private BigDecimal unitPrice;

     public ordersProducts() {
     }

     // Constructor with parameters

     public ordersProducts(int orderProduct_id, orders order, products product, int quantity, BigDecimal unitPrice) {
          this.orderProduct_id = orderProduct_id;
          this.order = order;
          this.product = product;
          this.quantity = quantity;
          this.unitPrice = unitPrice;
     }

     public int getOrderProductId() {
          return orderProduct_id;
     }

     public void setorderProduct_id(int orderProduct_id) {
          this.orderProduct_id = orderProduct_id;
     }

     public orders get_order() {
          return order;
     }

     public void set_order(orders order) {
          this.order = order;
     }

     public products get_product() {
          return product;
     }

     public void set_product(products product) {
          this.product = product;
     }

     public int get_quantity() {
          return quantity;
     }

     public void set_quantity(int quantity) {
          this.quantity = quantity;
     }

     public BigDecimal get_unitPrice() {
          return unitPrice;
     }

     public void setunitPrice(BigDecimal unitPrice) {
          this.unitPrice = unitPrice;
     }

}
