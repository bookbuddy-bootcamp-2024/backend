package com.creditacceptance.bookbuddy.com.bookbuddybe.controllers;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.ResWithBookDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.ReservationDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.ReservationRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reservations")

public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;

    @GetMapping("{userid}")
    public List<ResWithBookDto> getResByUserId(@PathVariable Long userid) {
        return reservationRepository.findReservationsByUserId(userid);
    }

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        ReservationDto createdReservation = reservationService.createReservation(reservationDto);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity.ok("Reservation successfully deleted");

    }
}
