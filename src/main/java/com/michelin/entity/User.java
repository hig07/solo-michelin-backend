package com.michelin.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 50, unique = true)
    private String email; //(중복 방지)

    @Column(nullable = false, length = 100)
    private String password;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private String created; // 가입일

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private int deleted;

}
