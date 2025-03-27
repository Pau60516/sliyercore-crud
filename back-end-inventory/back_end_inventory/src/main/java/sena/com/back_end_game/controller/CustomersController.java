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

import sena.com.back_end_game.DTO.CustomersDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.CustomersService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private CustomersService customersService;

    @PostMapping("/")
    public ResponseEntity<Object> registerCustomer(@RequestBody CustomersDTO customer) {
        responseDTO respuesta = customersService.save(customer);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCustomers() {
        var listaClientes = customersService.findAll();
        // List<Customer> listaClientes2 = customersService.findAll();
        return new ResponseEntity<>(listaClientes, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCustomer(@PathVariable int id) {
        var cliente = customersService.findById(id);
        if (!cliente.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int id) {
        var message = customersService.deleteCustomer(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
