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

import sena.com.back_end_game.DTO.ProductsDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.ProductsService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private ProductsService productsService;

    @PostMapping("/")
    public ResponseEntity<Object> registerProduct(@RequestBody ProductsDTO product) {
        responseDTO respuesta = productsService.save(product);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllProducts() {
        var listaProductos = productsService.findAll();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable int id) {
        var producto = productsService.findById(id);
        if (!producto.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        var message = productsService.deleteProduct(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
