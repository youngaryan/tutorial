package com.ss_l2_2.ss_l2_2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss_l2_2.ss_l2_2.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
