package sena.com.back_end_game.DTO;

import sena.com.back_end_game.model.Orders;
import sena.com.back_end_game.model.Products;

public class OrdersProductsDTO {

    private int orderProductId;
    private Orders order;
    private Products product;
    private int quantity;
    private double unitPrice;

    public OrdersProductsDTO(int orderProductId, Orders order, Products product, int quantity, double unitPrice) {
        this.orderProductId = orderProductId;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}

