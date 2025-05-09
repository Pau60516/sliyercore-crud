package sena.com.back_end_game.controller;

import org.springframework.web.bind.annotation.RestController;

import sena.com.back_end_game.DTO.BrandDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.service.BrandsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    @PostMapping("/")
    public ResponseEntity<Object> registerBrand(@RequestBody BrandDTO brand) {
        responseDTO respuesta = brandsService.save(brand);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllBrands() {
        var brandList = brandsService.findAll();
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneBrand(@PathVariable int id) {
        var brand = brandsService.findById(id);
        if (!brand.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBrand(@PathVariable int id) {
        var response = brandsService.deleteBrand(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
