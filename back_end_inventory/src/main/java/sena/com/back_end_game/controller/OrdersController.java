package sena.com.back_end_game.controller;

import org.springframework.web.bind.annotation.RestController;
import sena.com.back_end_game.DTO.OrderDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.service.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders/")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/")
    public ResponseEntity<Object> registerOrder(@RequestBody OrderDTO order) {
        responseDTO response = ordersService.save(order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllOrders() {
        var orderList = ordersService.findAll();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneOrder(@PathVariable int id) {
        var order = ordersService.findById(id);
        if (!order.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable int id) {
        var response = ordersService.deleteOrder(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
