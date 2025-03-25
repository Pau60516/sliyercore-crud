package sena.com.back_end_game.DTO;

import java.time.LocalDateTime;

public class OrdersDTO {

    private int orderId;
    private CustomersDTO customer;    
    private LocalDateTime date;
    private double total;
    private String status;

    public OrdersDTO(int orderId, CustomersDTO customer, LocalDateTime date, double total, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CustomersDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersDTO customer) {
        this.customer = customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

