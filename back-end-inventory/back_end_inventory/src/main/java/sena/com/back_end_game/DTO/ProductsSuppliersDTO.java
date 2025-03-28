package sena.com.back_end_game.DTO;

import sena.com.back_end_game.model.Products;
import sena.com.back_end_game.model.Suppliers;

public class ProductsSuppliersDTO {

    private int productSupplierId;
    private Products product;
    private Suppliers supplier;

    public ProductsSuppliersDTO(int productSupplierId, Products product, Suppliers supplier) {
        this.productSupplierId = productSupplierId;
        this.product = product;
        this.supplier = supplier;
    }

    public int getproductSupplier_Id() {
        return productSupplierId;
    }

    public void setproductSupplier_Id(int productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }
}


    

