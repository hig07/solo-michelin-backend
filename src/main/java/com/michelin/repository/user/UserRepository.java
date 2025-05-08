package com.michelin.repository.user;

import com.michelin.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 기본 CRUD 제공 (findAll, findById, save, deleteById 등)
}
