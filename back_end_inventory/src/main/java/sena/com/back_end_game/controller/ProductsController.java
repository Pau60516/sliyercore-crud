package sena.com.back_end_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.com.back_end_game.DTO.ProductDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.service.ProductsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {

    @Autowired
    private ProductsService productService;

    // Endpoint para registrar un producto
    @PostMapping("/")
    public ResponseEntity<Object> registerProduct(@RequestBody ProductDTO productDTO) {
        responseDTO response = productService.save(productDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para obtener todos los productos
    @GetMapping("/")
    public ResponseEntity<Object> getAllProducts() {
        List<ProductDTO> products = productService.findAll().stream()
                .map(productService::convertToDTO)
                .toList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Endpoint para obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable int id) {
        Optional<ProductDTO> product = productService.findById(id)
                .map(productService::convertToDTO);
        if (!product.isPresent()) {
            return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    // Endpoint para eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        responseDTO response = productService.deleteProduct(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
