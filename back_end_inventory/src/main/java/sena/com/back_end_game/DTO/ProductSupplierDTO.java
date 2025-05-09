package sena.com.back_end_game.DTO;

public class ProductSupplierDTO {

    private int productSupplierId;
    private int productId;
    private int supplierId;

    public ProductSupplierDTO() {
    }

    public ProductSupplierDTO(int productSupplierId, int productId, int supplierId) {
        this.productSupplierId = productSupplierId;
        this.productId = productId;
        this.supplierId = supplierId;
    }

    public int getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(int productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}

