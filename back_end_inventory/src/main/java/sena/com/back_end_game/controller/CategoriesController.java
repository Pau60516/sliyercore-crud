package sena.com.back_end_game.controller;

import org.springframework.web.bind.annotation.RestController;

import sena.com.back_end_game.DTO.CategoryDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.service.CategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories/")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("/")
    public ResponseEntity<Object> registerCategory(@RequestBody CategoryDTO category) {
        responseDTO respuesta = categoriesService.save(category);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCategories() {
        var categoryList = categoriesService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCategory(@PathVariable int id) {
        var category = categoriesService.findById(id);
        if (!category.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
        var response = categoriesService.deleteCategory(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
