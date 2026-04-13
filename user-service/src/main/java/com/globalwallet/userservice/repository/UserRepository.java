package com.globalwallet.userservice.repository;

import com.globalwallet.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}