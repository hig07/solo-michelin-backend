package com.michelin.service.review;

import com.michelin.dto.review.ReviewRequest;
import com.michelin.dto.review.ReviewResponse;

import java.util.List;

public interface ReviewService {
    ReviewResponse createReview(ReviewRequest request);
    List<ReviewResponse> getAllReviews();
    ReviewResponse getReviewById(Long id);
    ReviewResponse updateReview(Long id, ReviewRequest request);
    void deleteReview(Long id);

    List<ReviewResponse> getReviewsByUserId(Long userId);
}
