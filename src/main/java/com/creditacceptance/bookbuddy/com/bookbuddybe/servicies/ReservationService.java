package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.ReservationDto;

public interface ReservationService {
    ReservationDto createReservation(ReservationDto reservationDto);
    ReservationDto getReservationById(Long id);
    void deleteReservationById(Long id);
}
