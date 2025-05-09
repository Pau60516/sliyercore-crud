package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.BrandDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.brands;
import sena.com.back_end_game.repository.IBrands;

import java.util.List;
import java.util.Optional;

@Service
public class BrandsService {

    @Autowired
    private IBrands data;

    // Buscar todos los registros
    public List<brands> findAll() {
        return data.findAll();
    }

    // Buscar un registro por su id
    public Optional<brands> findById(int id) {
        return data.findById(id);
    }

    // Eliminar una marca (desactivarla)
    public responseDTO deleteBrand(int id) {
        Optional<brands> brand = findById(id);

        if (!brand.isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "La marca no existe");
        }

        data.deleteById(id);

        return new responseDTO(
                HttpStatus.OK.toString(),
                "Marca eliminada correctamente");
    }

    // Guardar o actualizar una marca
    public responseDTO save(BrandDTO brandDTO) {
        // Validación del nombre
        if (brandDTO.getName().length() < 1 || brandDTO.getName().length() > 150) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El nombre debe estar entre 1 y 150 caracteres");
        }

        // Convertir DTO a modelo de marca
        brands brandRegister = convertToModel(brandDTO);
        data.save(brandRegister);

        return new responseDTO(
                HttpStatus.OK.toString(),
                "Marca guardada correctamente");
    }

    // Convertir un modelo de marca a DTO
    public BrandDTO convertToDTO(brands brand) {
        return new BrandDTO(
                brand.getbrand_id(),
                brand.get_name(),
                brand.get_originCountry());
    }

    // Convertir un DTO a modelo de marca
    public brands convertToModel(BrandDTO brandDTO) {
        return new brands(
                brandDTO.getBrandId(),
                brandDTO.getName(),
                brandDTO.getOriginCountry());
    }
}
