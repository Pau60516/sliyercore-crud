package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.CategoryDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.categories;
import sena.com.back_end_game.repository.ICategories;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    private ICategories data;

    public List<categories> findAll() {
        return data.findAll();
    }

    public Optional<categories> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteCategory(int id) {
        Optional<categories> category = findById(id);
        if (!category.isPresent()) {
            return new responseDTO(HttpStatus.OK.toString(), "The register does not exist");
        }
        data.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public responseDTO save(CategoryDTO categoryDTO) {
        if (categoryDTO.getName().length() < 1 || categoryDTO.getName().length() > 150) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El nombre debe estar entre 1 y 150 caracteres");
        }

        categories categoryToSave = convertToModel(categoryDTO);
        data.save(categoryToSave);
        return new responseDTO(HttpStatus.OK.toString(), "Se guardó correctamente");
    }

    public CategoryDTO convertToDTO(categories category) {
        return new CategoryDTO(
                category.getcategory_id(),
                category.get_name(),
                category.get_description()
        );
    }

    public categories convertToModel(CategoryDTO dto) {
        return new categories(
                dto.getCategoryId(),
                dto.getName(),
                dto.getDescription()
        );
    }
}
