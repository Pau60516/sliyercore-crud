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

import sena.com.back_end_game.DTO.ReviewsDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.ReviewsService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/")
    public ResponseEntity<Object> registerReview(@RequestBody ReviewsDTO review) {
        responseDTO respuesta = reviewsService.save(review);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllReviews() {
        var listaReviews = reviewsService.findAll();
        return new ResponseEntity<>(listaReviews, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneReview(@PathVariable int id) {
        var review = reviewsService.findById(id);
        if (!review.isPresent()) {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReview(@PathVariable int id) {
        var message = reviewsService.deleteReview(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
