package sena.com.back_end_game.DTO;

import sena.com.back_end_game.model.Brands;
import sena.com.back_end_game.model.Categories;

public class ProductsDTO {

    private int productId;
    private Brands brand;
    private Categories category;
    private String name;
    private String color;
    private String description;
    private double price;

    public ProductsDTO(int productId, Brands brand, Categories category, String name, String color, String description, double price) {
        this.productId = productId;
        this.brand = brand;
        this.category = category;
        this.name = name;
        this.color = color;
        this.description = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

    

