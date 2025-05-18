package com.michelin.service.review;

import com.michelin.dto.review.ReviewRequest;
import com.michelin.dto.review.ReviewResponse;
import com.michelin.entity.restaurant.Restaurant;
import com.michelin.entity.review.Review;
import com.michelin.entity.user.User;
import com.michelin.repository.restaurant.RestaurantRepository;
import com.michelin.repository.review.ReviewRepository;
import com.michelin.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }
    @Override
    @Transactional
    public ReviewResponse createReview(ReviewRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("사용자를 찾을 수 없습니다."));
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("음식점을 찾을 수 없습니다."));
        Review review = new Review();
        review.setUser(user);
        review.setRestaurant(restaurant);
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setCreated(LocalDateTime.now());
        review.setDeleted(0);
        return ReviewResponse.from(reviewRepository.save(review));
    }

    @Override
    public List<ReviewResponse> getAllReviews() {
        return reviewRepository.findAll().stream()
                .filter(r -> r.getDeleted() == 0)
                .map(ReviewResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponse getReviewById(Long id) {
        Review review =  reviewRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("리뷰를 찾을 수 없습니다."));
        return ReviewResponse.from(review);
    }

    @Override
    @Transactional
    public ReviewResponse updateReview(Long id, ReviewRequest request) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()->new RuntimeException("리뷰를 찾을 수 없습니다."));
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setModified(LocalDateTime.now());
        return ReviewResponse.from(reviewRepository.save(review));
    }

    @Override
    @Transactional
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()->new RuntimeException("리뷰를 찾을 수 없습니다."));
        review.setDeleted(1);
        reviewRepository.save(review);
    }

    @Override
    public List<ReviewResponse> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserIdAndDeleted(userId, 0).stream()
                .map(ReviewResponse::from)
                .collect(Collectors.toList());
    }
}
