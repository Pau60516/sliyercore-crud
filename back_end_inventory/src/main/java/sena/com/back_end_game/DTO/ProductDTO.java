package sena.com.back_end_game.DTO;

public class ProductDTO {

    private int productId;
    private int brandId;
    private int categoryId;
    private String name;
    private String color;
    private String description;
    private Double price;

    public ProductDTO() {
    }

    public ProductDTO(int productId, int brandId, int categoryId, String name, String color, String description, Double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.categoryId = categoryId;
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

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
