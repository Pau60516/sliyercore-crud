package sena.com.back_end_game.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.ReviewsDTO;
import sena.com.back_end_game.model.Reviews;
import sena.com.back_end_game.repository.IReviews;
import sena.com.back_end_game.DTO.responseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {
    
    @Autowired
    private IReviews data;

    public List<Reviews> findAll() {
        return data.findAll();
    }

    public Optional<Reviews> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteReview(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The review does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Review deleted successfully");
    }

    public responseDTO save(ReviewsDTO reviewsDTO) {
        Reviews review = convertToEntity(reviewsDTO);
        data.save(review);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Review saved successfully");
    }

    public ReviewsDTO convertToDTO(Reviews review) {
        return new ReviewsDTO(
                review.getReviewId(),
                review.getCustomer(),
                review.getProduct(),
                review.getRating(),
                review.getComment(),
                review.getDate()
        );
    }

    public Reviews convertToEntity(ReviewsDTO reviewsDTO) {
        return new Reviews(
                reviewsDTO.getReviewId(),
                reviewsDTO.getCustomer(),
                reviewsDTO.getProduct(),
                reviewsDTO.getRating(),
                reviewsDTO.getComment(),
                reviewsDTO.getDate()
        );
    }
}
