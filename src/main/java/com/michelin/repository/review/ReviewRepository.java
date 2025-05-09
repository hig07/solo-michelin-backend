package com.michelin.repository.review;

import com.michelin.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository  extends JpaRepository<Review, Long> {
}
