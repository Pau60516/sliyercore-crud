package sena.com.back_end_game.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import sena.com.back_end_game.DTO.BrandsDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.Brands;
import sena.com.back_end_game.repository.IBrands;

public class BrandsService {

     @Autowired
    private IBrands data;

    public List<Brands> findAll() {
        return data.findAll();
    }

    public Optional<Brands> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteBrand(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The brand does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Brand deleted successfully");
    }

    public responseDTO save(BrandsDTO brandsDTO) {
        if (brandsDTO.get_name().length() < 1 || brandsDTO.get_name().length() > 50) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "The brand name must be between 1 and 50 characters");
        }
        Brands brand = convertToModel(brandsDTO);
        data.save(brand);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Brand saved successfully");
    }

    public BrandsDTO convertToDTO(Brands brand) {
        return new BrandsDTO(
                brand.get_name(),
                brand.get_originCountry());
    }

    public Brands convertToModel(BrandsDTO brandsDTO) {
        return new Brands(
                0,
                brandsDTO.get_name(),
                brandsDTO.get_originCountry());
    }
}

    

