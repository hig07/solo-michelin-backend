package com.michelin.entity.review;
import com.michelin.entity.restaurant.Restaurant;
import com.michelin.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 리뷰 고유 ID

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;  // FK: 음식점

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // FK: 작성자

    @Column(nullable = false)
    private float rating;  // 별점

    @Column(columnDefinition = "TEXT")
    private String comment;  // 한줄평

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private int deleted;  // 삭제 여부 (0: 정상, 1: 삭제됨)

}
