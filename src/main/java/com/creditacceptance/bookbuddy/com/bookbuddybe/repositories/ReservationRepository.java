package com.creditacceptance.bookbuddy.com.bookbuddybe.repositories;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.ResWithBookDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {
    @Query("SELECT new com.creditacceptance.bookbuddy.com.bookbuddybe.dto.ResWithBookDto(reservations.id, books.id, " +
            "books.title, books.author, books.description, books.coverimage ) FROM Reservation reservations " +
            "JOIN Book books ON reservations.book.id = books.id AND reservations.user.id=?1")
    List<ResWithBookDto> findReservationsByUserId(Long userId);
}

