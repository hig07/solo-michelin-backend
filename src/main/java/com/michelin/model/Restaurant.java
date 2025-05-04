package com.michelin.model;

import jakarta.persistence.*;
import lombok.Cleanup;

@Entity
@Table(name = "restaurant")
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
	private String created;  // 등록일

	@Column(columnDefinition = "TINYINT(1) DEFAULT 0")
	private int deleted;  // 삭제 여부 (0: 정상, 1: 삭제됨)
    
//    public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getMap_url() {
//		return map_url;
//	}
//	public void setMap_url(String map_url) {
//		this.map_url = map_url;
//	}
//	public String getAvg_rating() {
//		return avg_rating;
//	}
//	public void setAvg_rating(String avg_rating) {
//		this.avg_rating = avg_rating;
//	}
//	public String getInsert_dt() {
//		return insert_dt;
//	}
//	public void setInsert_dt(String insert_dt) {
//		this.insert_dt = insert_dt;
//	}
//	public String getUpdate_dt() {
//		return update_dt;
//	}
//	public void setUpdate_dt(String update_dt) {
//		this.update_dt = update_dt;
//	}
//	public String getDelete_yn() {
//		return delete_yn;
//	}
//	public void setDelete_yn(String delete_yn) {
//		this.delete_yn = delete_yn;
//	}
//
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}

}
