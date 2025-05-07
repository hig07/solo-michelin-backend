package com.michelin.service;

import com.michelin.dto.UserRequest;
import com.michelin.dto.UserResponse;
import com.michelin.entity.User;
import com.michelin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword()) // 추후 암호화 처리 (?)
                .created(LocalDateTime.now())
                .deleted(false)
                .build();
        return UserResponse.from(userRepository.save(user));
    }
}
