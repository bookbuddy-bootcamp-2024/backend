package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.impl;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.ReservationDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Book;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Reservation;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.User;
import com.creditacceptance.bookbuddy.com.bookbuddybe.exceptions.ResourceNotFound;
import com.creditacceptance.bookbuddy.com.bookbuddybe.mapper.ReservationMapper;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.BookRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.ReservationRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.UserRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        User user = userRepository.findById(reservationDto.getUserid()).orElseThrow(()-> new ResourceNotFound("No user found"));
        Book book = bookRepository.findById(reservationDto.getBookid()).orElseThrow(()-> new ResourceNotFound("No book found"));
        reservation.setUser(user);
        reservation.setBook(book);
        Reservation saveReservation = reservationRepository.save(reservation);

        return ReservationMapper.mapToReservationDto(saveReservation);
    }

    @Override
    public ReservationDto getReservationById(Long id) {
        return null;
    }

    @Override
    public void deleteReservationById(Long id) {
        Reservation restoDelete = reservationRepository.findById(id).orElseThrow(()-> new ResourceNotFound("No reservation found with that id"));
        reservationRepository.delete(restoDelete);

    }
}
