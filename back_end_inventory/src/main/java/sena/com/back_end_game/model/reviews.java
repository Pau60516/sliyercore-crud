package sena.com.back_end_game.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private customers customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private products product;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    public reviews() {
    }

    public reviews(int reviewId, customers customer, products product, int rating, String comment, LocalDateTime date) {
        this.reviewId = reviewId;
        this.customer = customer;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public customers getCustomer() {
        return customer;
    }

    public void setCustomer(customers customer) {
        this.customer = customer;
    }

    public products getProduct() {
        return product;
    }

    public void setProduct(products product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
