package com.michelin.repository.review;

import com.michelin.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review, Long> {
    List<Review> findByUserIdAndDeleted(Long userId, int deleted);
}
