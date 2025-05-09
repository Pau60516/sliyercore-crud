package sena.com.back_end_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.com.back_end_game.DTO.SupplierDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.suppliers;
import sena.com.back_end_game.service.SuppliersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersService service;

    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<List<suppliers>> getAll() {
        List<suppliers> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    // Obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<suppliers> supplier = service.findById(id);
        if (supplier.isPresent()) {
            return ResponseEntity.ok(supplier.get());
        }
        return ResponseEntity.status(404).body("El proveedor no existe");
    }

    // Guardar o actualizar un proveedor
    @PostMapping
    public ResponseEntity<responseDTO> save(@RequestBody SupplierDTO dto) {
        responseDTO response = service.save(dto);
        return ResponseEntity.status(Integer.parseInt(response.getStatus())).body(response);
    }

    // Eliminar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<responseDTO> delete(@PathVariable int id) {
        responseDTO response = service.deleteSupplier(id);
        return ResponseEntity.status(Integer.parseInt(response.getStatus())).body(response);
    }
}
