package com.creditacceptance.bookbuddy.com.bookbuddybe.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReservationDto {
    private Long id;
    private Long bookid;
    private Long userid;
}
