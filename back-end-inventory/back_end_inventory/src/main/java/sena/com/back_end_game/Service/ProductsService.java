package sena.com.back_end_game.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.ProductsDTO;
import sena.com.back_end_game.model.Products;
import sena.com.back_end_game.repository.IProducts;
import sena.com.back_end_game.DTO.responseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private IProducts data;

    public List<Products> findAll() {
        return data.findAll();
    }

    public Optional<Products> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteProduct(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The product does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Product deleted successfully");
    }

    public responseDTO save(ProductsDTO productsDTO) {
        if (productsDTO.getName().length() < 1 || productsDTO.getName().length() > 100) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "The product name must be between 1 and 100 characters");
        }
        if (productsDTO.getPrice() < 0) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "The price cannot be negative");
        }
        Products product = convertToModel(productsDTO);
        data.save(product);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Product saved successfully");
    }

    public ProductsDTO convertToDTO(Products product) {
        return new ProductsDTO(
                product.getproduct_Id(),  
                product.get_brand(),
                product.get_category(),
                product.get_name(),
                product.get_color(),
                product.get_description(),
                product.getPrice()
        );
    }

    public Products convertToModel(ProductsDTO productsDTO) {
        return new Products(
                productsDTO.getproduct_Id(),  
                productsDTO.getBrand(),
                productsDTO.getCategory(),
                productsDTO.getName(),
                productsDTO.getColor(),
                productsDTO.get_description(),
                productsDTO.getPrice()
        );
    }
}



