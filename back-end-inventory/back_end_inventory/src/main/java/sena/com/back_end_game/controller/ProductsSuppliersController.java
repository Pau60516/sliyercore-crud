package sena.com.back_end_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sena.com.back_end_game.DTO.ProductsSuppliersDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.ProductsSuppliersService;

@RestController
@RequestMapping("/api/v1/products-suppliers")
public class ProductsSuppliersController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private ProductsSuppliersService productsSuppliersService;

    @PostMapping("/")
    public ResponseEntity<Object> registerProductsSuppliers(@RequestBody ProductsSuppliersDTO productsSuppliers) {
        responseDTO respuesta = productsSuppliersService.save(productsSuppliers);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllProductsSuppliers() {
        var listaProductsSuppliers = productsSuppliersService.findAll();
        return new ResponseEntity<>(listaProductsSuppliers, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProductsSuppliers(@PathVariable int id) {
        var productsSuppliers = productsSuppliersService.findById(id);
        if (!productsSuppliers.isPresent()) {
            return new ResponseEntity<>("ProductsSuppliers not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productsSuppliers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductsSupplier(@PathVariable int id){
        var message = productsSuppliersService.deleteProductSupplier(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}