package com.michelin.dto.user;

import com.michelin.entity.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime created;

    public static UserResponse from(User user){ // 鍮꾨�踰덊샇,�궘�젣�뿬遺� �닲源�
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .created(user.getCreated())
                .build();
    }
}
