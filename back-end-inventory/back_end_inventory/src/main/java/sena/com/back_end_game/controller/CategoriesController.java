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

import sena.com.back_end_game.DTO.CategoriesDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.CategoriesService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("/")
    public ResponseEntity<Object> registerCategory(@RequestBody CategoriesDTO category) {
        responseDTO respuesta = categoriesService.save(category);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCategories() {
        var listaCategorias = categoriesService.findAll();
        // List<Category> listaCategorias2 = categoriesService.findAll();
        return new ResponseEntity<>(listaCategorias, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCategory(@PathVariable int id) {
        var categoria = categoriesService.findById(id);
        if (!categoria.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
        var message = categoriesService.deleteCategory(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
