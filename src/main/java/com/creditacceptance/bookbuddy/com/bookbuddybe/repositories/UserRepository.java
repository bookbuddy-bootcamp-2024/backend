package com.creditacceptance.bookbuddy.com.bookbuddybe.repositories;

import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Boolean existsByUsername(String username);

}
