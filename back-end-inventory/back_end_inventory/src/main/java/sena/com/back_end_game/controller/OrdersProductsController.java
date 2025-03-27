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

import sena.com.back_end_game.DTO.OrdersProductsDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.OrdersProductsService;

@RestController
@RequestMapping("/api/v1/orders-products")
public class OrdersProductsController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private OrdersProductsService ordersProductsService;

    @PostMapping("/")
    public ResponseEntity<Object> registerOrderProduct(@RequestBody OrdersProductsDTO orderProduct) {
        responseDTO respuesta = ordersProductsService.save(orderProduct);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllOrdersProducts() {
        var listaOrdenesProductos = ordersProductsService.findAll();
        return new ResponseEntity<>(listaOrdenesProductos, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneOrderProduct(@PathVariable int id) {
        var ordenProducto = ordersProductsService.findById(id);
        if (!ordenProducto.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ordenProducto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrderProduct(@PathVariable int id) {
        var message = ordersProductsService.deleteOrderProduct(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
