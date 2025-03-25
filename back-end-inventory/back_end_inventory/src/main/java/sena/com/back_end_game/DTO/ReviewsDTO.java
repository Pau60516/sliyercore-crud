package sena.com.back_end_game.DTO;

import sena.com.back_end_game.model.Customers;
import sena.com.back_end_game.model.Products;
import java.time.LocalDateTime;

public class ReviewsDTO {

    private int reviewId;
    private Customers customer;
    private Products product;
    private int rating;
    private String comment;
    private LocalDateTime date;

    public ReviewsDTO(int reviewId, Customers customer, Products product, int rating, String comment, LocalDateTime date) {
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

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
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




