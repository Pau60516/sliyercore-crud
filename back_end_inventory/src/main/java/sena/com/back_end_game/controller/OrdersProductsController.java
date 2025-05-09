package sena.com.back_end_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.com.back_end_game.DTO.OrderProductDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.service.OrdersProductsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ordersProducts/")
public class OrdersProductsController {

    @Autowired
    private OrdersProductsService ordersProductsService;

    @PostMapping("/")
    public ResponseEntity<Object> registerOrderProduct(@RequestBody OrderProductDTO orderProduct) {
        responseDTO response = ordersProductsService.save(orderProduct);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllOrderProducts() {
        List<OrderProductDTO> orderProducts = ordersProductsService.findAll().stream()
                .map(ordersProductsService::convertToDTO)
                .toList();
        return new ResponseEntity<>(orderProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneOrderProduct(@PathVariable int id) {
        Optional<OrderProductDTO> orderProduct = ordersProductsService.findById(id)
                .map(ordersProductsService::convertToDTO);
        if (!orderProduct.isPresent())
            return new ResponseEntity<>("El producto de la orden no existe", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(orderProduct.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrderProduct(@PathVariable int id) {
        responseDTO response = ordersProductsService.deleteOrderProduct(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}