package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.ProductDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.brands;
import sena.com.back_end_game.model.categories;
import sena.com.back_end_game.model.products;
import sena.com.back_end_game.repository.IBrands;
import sena.com.back_end_game.repository.ICategories;
import sena.com.back_end_game.repository.IProducts;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private IProducts productRepository;

    @Autowired
    private IBrands brandRepository;

    @Autowired
    private ICategories categoryRepository;

    public List<products> findAll() {
        return productRepository.findAll();
    }

    public Optional<products> findById(int id) {
        return productRepository.findById(id);
    }

    public responseDTO deleteProduct(int id) {
        Optional<products> product = findById(id);
        if (!product.isPresent()) {
            return new responseDTO(HttpStatus.OK.toString(), "El producto no existe");
        }
        productRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Producto eliminado correctamente");
    }

    public responseDTO save(ProductDTO dto) {
        Optional<brands> brand = brandRepository.findById(dto.getBrandId());
        if (!brand.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La marca no existe");
        }

        Optional<categories> category = categoryRepository.findById(dto.getCategoryId());
        if (!category.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La categoría no existe");
        }

        if (dto.getName().isEmpty() || dto.getDescription().isEmpty() || dto.getColor().isEmpty()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "Campos obligatorios vacíos");
        }

        if (dto.getPrice() < 0) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El precio no puede ser negativo");
        }

        products entity = convertToModel(dto, brand.get(), category.get());
        productRepository.save(entity);
        return new responseDTO(HttpStatus.OK.toString(), "Producto guardado correctamente");
    }

    public ProductDTO convertToDTO(products entity) {
        return new ProductDTO(
            entity.getproduct_Id(),
            entity.get_brand().getbrand_id(),
            entity.get_category().getcategory_id(),
            entity.get_name(),
            entity.get_color(),
            entity.get_description(),
            entity.getPrice()
        );
    }

    public products convertToModel(ProductDTO dto, brands brand, categories category) {
        return new products(
            dto.getProductId(),
            brand,
            category,
            dto.getName(),
            dto.getColor(),
            dto.getDescription(),
            dto.getPrice()
        );
    }
}
