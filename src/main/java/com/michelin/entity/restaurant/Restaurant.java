package com.michelin.entity.restaurant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	//Restaurant 테이블
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//	음식점 고유 ID

	@Column(nullable = false, length = 20)
    private String name;		//음식점 이름

	@Column(nullable = false, length = 100)
    private String address;		//음식점 주소

	@Column(nullable = false, length = 8)
    private String category;	//음식 종류

	@Column(columnDefinition = "TEXT")
    private String map_url;		//지도 링크

	@Column(columnDefinition = "FLOAT DEFAULT 0.0")
	private float avg_rating;  // 평균 별점

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created;

	@Column(columnDefinition = "TINYINT(1) DEFAULT 0")
	private int deleted;  // 삭제 여부 (0: 정상, 1: 삭제됨)


	public void setMapUrl(String mapUrl) {
		this.map_url = mapUrl;
	}
	public String getMapUrl() {
		return this.map_url;
	}

	public void setAvgRating(float avgRating) {
		this.avg_rating = avgRating;
	}
	public float getAvgRating() {
		return this.avg_rating;
	}
}
