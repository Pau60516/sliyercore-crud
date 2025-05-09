package sena.com.back_end_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sena.com.back_end_game.DTO.ProductSupplierDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.products;
import sena.com.back_end_game.model.productsSuppliers;
import sena.com.back_end_game.model.suppliers;
import sena.com.back_end_game.service.ProductsSuppliersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products-suppliers")
public class ProductsSuppliersController {

    @Autowired
    private ProductsSuppliersService service;

    @GetMapping
    public ResponseEntity<List<productsSuppliers>> getAll() {
        List<productsSuppliers> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<productsSuppliers> entity = service.findById(id);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }
        return ResponseEntity.status(404).body("La relación no existe");
    }

    @PostMapping
    public ResponseEntity<responseDTO> save(@RequestBody ProductSupplierDTO dto) {
        responseDTO response = service.save(dto);
        return ResponseEntity.status(Integer.parseInt(response.getStatus())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<responseDTO> delete(@PathVariable int id) {
        responseDTO response = service.deleteProductSupplier(id);
        return ResponseEntity.status(Integer.parseInt(response.getStatus())).body(response);
    }

    // Obtener productos por proveedor
@GetMapping("/supplier/{supplierId}/products")
public ResponseEntity<List<products>> getProductsBySupplierId(@PathVariable int supplierId) {
    List<products> products = service.findProductsBySupplierId(supplierId);
    return ResponseEntity.ok(products);
}

// Obtener proveedores por producto
@GetMapping("/product/{productId}/suppliers")
public ResponseEntity<List<suppliers>> getSuppliersByProductId(@PathVariable int productId) {
    List<suppliers> suppliers = service.findSuppliersByProductId(productId);
    return ResponseEntity.ok(suppliers);
}

}

