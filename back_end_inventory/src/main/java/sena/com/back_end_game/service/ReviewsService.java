package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.ReviewDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.customers;
import sena.com.back_end_game.model.products;
import sena.com.back_end_game.model.reviews;
import sena.com.back_end_game.repository.IReviews;
import sena.com.back_end_game.repository.ICustomers;
import sena.com.back_end_game.repository.IProducts;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {

    @Autowired
    private IReviews reviewRepository;

    @Autowired
    private ICustomers customerRepository;

    @Autowired
    private IProducts productRepository;

    // Obtener todas las reseñas
    public List<reviews> findAll() {
        return reviewRepository.findAll();
    }

    // Obtener una reseña por su id
    public Optional<reviews> findById(int id) {
        return reviewRepository.findById(id);
    }

    // Eliminar una reseña (lógica de eliminación suave)
    public responseDTO deleteReview(int id) {
        Optional<reviews> review = findById(id);
        if (!review.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND.toString(), "La reseña no existe");
        }
        reviewRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    // Guardar o actualizar una reseña
    public responseDTO save(ReviewDTO dto) {
        // Verificar si el cliente existe
        Optional<customers> customer = customerRepository.findById(dto.getCustomerId());
        if (!customer.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El cliente no existe");
        }

        // Verificar si el producto existe
        Optional<products> product = productRepository.findById(dto.getProductId());
        if (!product.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El producto no existe");
        }

        // Validación de la calificación
        if (dto.getRating() < 1 || dto.getRating() > 5) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La calificación debe estar entre 1 y 5");
        }

        // Convertir DTO a modelo y guardar la reseña
        reviews entity = convertToModel(dto, customer.get(), product.get());
        reviewRepository.save(entity);
        return new responseDTO(HttpStatus.OK.toString(), "Se guardó correctamente");
    }

    // Convertir un modelo de reseña a DTO
    public ReviewDTO convertToDTO(reviews entity) {
        return new ReviewDTO(
            entity.getReviewId(),
            entity.getCustomer().getcustomerss_id(),
            entity.getProduct().getproduct_Id(),
            entity.getRating(),
            entity.getComment(),
            entity.getDate()
        );
    }

    // Convertir un DTO a modelo de reseña
    public reviews convertToModel(ReviewDTO dto, customers customer, products product) {
        return new reviews(
            dto.getReviewId(),
            customer,
            product,
            dto.getRating(),
            dto.getComment(),
            dto.getDate()
        );
    }
}
