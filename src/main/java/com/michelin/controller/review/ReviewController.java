package com.michelin.controller.review;

import com.michelin.dto.review.ReviewRequest;
import com.michelin.dto.review.ReviewResponse;
import com.michelin.service.review.ReviewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    @PostMapping
    public ReviewResponse createReview(@RequestBody @Valid ReviewRequest request){
        return reviewService.createReview(request);
    }
    @GetMapping
    public List<ReviewResponse> getAllReviews(){
        return reviewService.getAllReviews();
    }
    @GetMapping("/{id}")
    public ReviewResponse getReviewById(@PathVariable Long id){
        return reviewService.getReviewById(id);
    }
    @PutMapping("/{id}")
    public ReviewResponse updateReview(@PathVariable Long id, @RequestBody @Valid ReviewRequest request){
        return reviewService.updateReview(id, request);
    }
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
    }

}
