package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.ProductSupplierDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.productsSuppliers;
import sena.com.back_end_game.model.products;
import sena.com.back_end_game.model.suppliers;
import sena.com.back_end_game.repository.IProductsSuppliers;
import sena.com.back_end_game.repository.IProducts;
import sena.com.back_end_game.repository.ISuppliers;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsSuppliersService {

    @Autowired
    private IProductsSuppliers productsSuppliersRepository;

    @Autowired
    private IProducts productsRepository;

    @Autowired
    private ISuppliers suppliersRepository;

    public List<productsSuppliers> findAll() {
        return productsSuppliersRepository.findAll();
    }

    public Optional<productsSuppliers> findById(int id) {
        return productsSuppliersRepository.findById(id);
    }

    public responseDTO deleteProductSupplier(int id) {
        Optional<productsSuppliers> relation = findById(id);
        if (!relation.isPresent()) {
            return new responseDTO(HttpStatus.OK.toString(), "La relación no existe");
        }

        productsSuppliersRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public responseDTO save(ProductSupplierDTO dto) {
        Optional<products> product = productsRepository.findById(dto.getProductId());
        if (!product.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El producto no existe");
        }

        Optional<suppliers> supplier = suppliersRepository.findById(dto.getSupplierId());
        if (!supplier.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El proveedor no existe");
        }

        productsSuppliers entity = convertToModel(dto, product.get(), supplier.get());
        productsSuppliersRepository.save(entity);
        return new responseDTO(HttpStatus.OK.toString(), "Se guardó correctamente");
    }

    public ProductSupplierDTO convertToDTO(productsSuppliers entity) {
        return new ProductSupplierDTO(
            entity.getproductsupplier_id(),
            entity.get_product().getproduct_Id(),
            entity.get_supplier().getSupplier_Id()
        );
    }

    public productsSuppliers convertToModel(ProductSupplierDTO dto, products product, suppliers supplier) {
        return new productsSuppliers(
            dto.getProductSupplierId(),
            product,
            supplier
        );
    }
    // Método para obtener productos por proveedor
    public List<products> findProductsBySupplierId(int supplierId) {
        return productsSuppliersRepository.findProductsBySupplierId(supplierId);
    }

    // Método para obtener proveedores por producto
    public List<suppliers> findSuppliersByProductId(int productId) {
        return productsSuppliersRepository.findSuppliersByProductId(productId);
    }
}


