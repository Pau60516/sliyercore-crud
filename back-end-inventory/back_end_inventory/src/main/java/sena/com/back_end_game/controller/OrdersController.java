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

import sena.com.back_end_game.DTO.OrdersDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.OrdersService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/")
    public ResponseEntity<Object> registerOrder(@RequestBody OrdersDTO order) {
        responseDTO respuesta = ordersService.save(order);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllOrders() {
        var listaOrdenes = ordersService.findAll();
        return new ResponseEntity<>(listaOrdenes, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneOrder(@PathVariable int id) {
        var orden = ordersService.findById(id);
        if (!orden.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(orden, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable int id) {
        var message = ordersService.deleteOrder(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
