package com.michelin.dto.review;

import com.michelin.entity.review.Review;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewResponse {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private float rating;
    private String comment;
    private LocalDateTime created;
    private LocalDateTime modified;

    public static ReviewResponse from(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .userId(review.getUser().getId())
                .restaurantId(review.getRestaurant().getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .created(LocalDateTime.now())
                .modified(review.getModified())
                .build();
    }

}
