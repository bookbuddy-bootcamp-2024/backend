package com.creditacceptance.bookbuddy.com.bookbuddybe.mapper;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.ReservationDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Reservation;

public class ReservationMapper {

        public static Reservation mapToReservation(ReservationDto reservationDto){
            Reservation reservation = new Reservation();
            return new Reservation();
        }

        public static ReservationDto mapToReservationDto(Reservation reservation){
            return new ReservationDto(reservation.getId(), reservation.getBook().getId(), reservation.getUser().getId());
        }
    }

