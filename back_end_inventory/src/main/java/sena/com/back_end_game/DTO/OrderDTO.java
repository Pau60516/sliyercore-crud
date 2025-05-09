package sena.com.back_end_game.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO {

    private int orderId;
    private int customerId;
    private LocalDateTime date;
    private BigDecimal total;
    private String status;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, int customerId, LocalDateTime date, BigDecimal total, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

