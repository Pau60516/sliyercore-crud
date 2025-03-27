package sena.com.back_end_game.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import sena.com.back_end_game.DTO.CategoriesDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.Categories;
import sena.com.back_end_game.repository.ICategories;

public class CategoriesService {
    
    @Autowired
    private ICategories data;

    public List<Categories> findAll() {
        return data.findAll();
    }

    public Optional<Categories> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteCategory(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The category does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Category deleted successfully");
    }

    public responseDTO save(CategoriesDTO categoriesDTO) {
        if (categoriesDTO.getname().length() < 1 || categoriesDTO.getname().length() > 50) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "The category name must be between 1 and 50 characters");
        }
        Categories category = convertToModel(categoriesDTO);
        data.save(category);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Category saved successfully");
    }

    public CategoriesDTO convertToDTO(Categories category) {
        return new CategoriesDTO(
                category.get_name(),
                category.get_description());
    }

    public Categories convertToModel(CategoriesDTO categoriesDTO) {
        return new Categories(
                0,
                categoriesDTO.getname(),
                categoriesDTO.getdescription());
    }
}