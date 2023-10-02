package com.ss_l2_e1.ss_l2_e1.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss_l2_e1.ss_l2_e1.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
