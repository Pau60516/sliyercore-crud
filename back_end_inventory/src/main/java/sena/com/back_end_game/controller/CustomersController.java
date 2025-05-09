package sena.com.back_end_game.controller;

import org.springframework.web.bind.annotation.RestController;
import sena.com.back_end_game.DTO.CustomerDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.service.CustomersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @PostMapping("/")
    public ResponseEntity<Object> registerCustomer(@RequestBody CustomerDTO customer) {
        responseDTO response = customersService.save(customer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCustomers() {
        var customerList = customersService.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCustomer(@PathVariable int id) {
        var customer = customersService.findById(id);
        if (!customer.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int id) {
        var response = customersService.deleteCustomer(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
