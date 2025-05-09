package sena.com.back_end_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sena.com.back_end_game.DTO.StockDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.stocks;
import sena.com.back_end_game.service.StocksService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StocksController {

    @Autowired
    private StocksService service;

    // Obtener todos los stocks
    @GetMapping
    public ResponseEntity<List<stocks>> getAll() {
        List<stocks> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    // Obtener un stock por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<stocks> entity = service.findById(id);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }
        return ResponseEntity.status(404).body("El stock no existe");
    }

    // Crear o actualizar un stock
    @PostMapping
    public ResponseEntity<responseDTO> save(@RequestBody StockDTO dto) {
        responseDTO response = service.save(dto);
        return ResponseEntity.status(Integer.parseInt(response.getStatus())).body(response);
    }

    // Eliminar un stock por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<responseDTO> delete(@PathVariable int id) {
        responseDTO response = service.deleteStock(id);
        return ResponseEntity.status(Integer.parseInt(response.getStatus())).body(response);
    }
}
