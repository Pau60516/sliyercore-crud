package sena.com.back_end_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sena.com.back_end_game.DTO.ReviewDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.reviews;
import sena.com.back_end_game.service.ReviewsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService service;

    // Obtener todas las reseñas
    @GetMapping
    public ResponseEntity<List<reviews>> getAll() {
        List<reviews> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    // Obtener una reseña por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<reviews> entity = service.findById(id);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        }
        return ResponseEntity.status(404).body("La reseña no existe");
    }

    // Guardar una nueva reseña
    @PostMapping
    public ResponseEntity<responseDTO> save(@RequestBody ReviewDTO dto) {
        responseDTO response = service.save(dto);
        return ResponseEntity.status(Integer.parseInt(response.getStatus())).body(response);
    }

    // Eliminar una reseña
    @DeleteMapping("/{id}")
    public ResponseEntity<responseDTO> delete(@PathVariable int id) {
        responseDTO response = service.deleteReview(id);
        return ResponseEntity.status(Integer.parseInt(response.getStatus())).body(response);
    }
}
