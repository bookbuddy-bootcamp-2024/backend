package com.creditacceptance.bookbuddy.com.bookbuddybe.repositories;

import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
