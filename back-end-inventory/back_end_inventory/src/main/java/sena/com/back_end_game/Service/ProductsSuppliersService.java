package sena.com.back_end_game.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.ProductsSuppliersDTO;
import sena.com.back_end_game.model.ProductsSuppliers;
import sena.com.back_end_game.repository.IProductsSuppliers;
import sena.com.back_end_game.DTO.responseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsSuppliersService {

    @Autowired
    private IProductsSuppliers data;

    public List<ProductsSuppliers> findAll() {
        return data.findAll();
    }

    public Optional<ProductsSuppliers> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteProductSupplier(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The product supplier does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Product supplier deleted successfully");
    }

    public responseDTO save(ProductsSuppliersDTO productsSupplierDTO) {
        ProductsSuppliers productSupplier = convertToModel(productsSupplierDTO);
        data.save(productSupplier);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Product supplier saved successfully");
    }

    public ProductsSuppliersDTO convertToDTO(ProductsSuppliers productSupplier) {
        return new ProductsSuppliersDTO(
                productSupplier.getproductSupplier_id(),
                productSupplier.get_product(),
                productSupplier.get_supplier());
    }

    public ProductsSuppliers convertToModel(ProductsSuppliersDTO productsSupplierDTO) {
        return new ProductsSuppliers(
                productsSupplierDTO.getproductSupplier_Id(),
                productsSupplierDTO.getProduct(),
                productsSupplierDTO.getSupplier());
    }

}
