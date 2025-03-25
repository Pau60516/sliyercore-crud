package sena.com.back_end_game.DTO;

import sena.com.back_end_game.model.Products;

public class StocksDTO {
    
    private int stockId;
    private Products product;
    private int quantity;

    public StocksDTO(int stockId, Products product, int quantity) {
        this.stockId = stockId;
        this.product = product;
        this.quantity = quantity;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
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
}
