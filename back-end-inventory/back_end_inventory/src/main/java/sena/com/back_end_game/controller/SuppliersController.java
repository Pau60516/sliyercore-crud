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

import sena.com.back_end_game.DTO.SuppliersDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.SuppliersService;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SuppliersController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private SuppliersService suppliersService;

    @PostMapping("/")
    public ResponseEntity<Object> registerSuppliers(@RequestBody SuppliersDTO suppliers) {
        responseDTO respuesta = suppliersService.save(suppliers);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllSuppliers() {
        var listaSuppliers = suppliersService.findAll();
        return new ResponseEntity<>(listaSuppliers, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSuppliers(@PathVariable int id) {
        var suppliers = suppliersService.findById(id);
        if (!suppliers.isPresent()) {
            return new ResponseEntity<>("Suppliers not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSuppliers(@PathVariable int id) {
        var message = suppliersService.deleteSupplier(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
