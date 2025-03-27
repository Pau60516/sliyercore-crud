package sena.com.back_end_game.DTO;

import sena.com.back_end_game.model.Brands;
import sena.com.back_end_game.model.Categories;

public class ProductsDTO {

    private int product_Id;
    private Brands brand;
    private Categories category;
    private String name;
    private String color;
    private String description;
    private double price;

    public ProductsDTO(int product_Id, Brands brand, Categories category, String name, String color, String description, double price) {
        this.product_Id = product_Id;
        this.brand = brand;
        this.category = category;
        this.name = name;
        this.color = color;
        this.description = description;
        this.price = price;
    }

    public int getproduct_Id() {
        return product_Id;
    }

    public void setproduct_Id(int product_Id) {
        this.product_Id = product_Id;
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

    public String get_description() {
        return description;
    }

    public void set_description(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

    

