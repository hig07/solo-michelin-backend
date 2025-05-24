package com.michelin.entity.user;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    private LocalDateTime created;

    private boolean deleted;

    protected void onCreate() {
        this.created = LocalDateTime.now();
    }
}
