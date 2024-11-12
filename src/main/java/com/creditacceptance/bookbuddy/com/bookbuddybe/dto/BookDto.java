package com.creditacceptance.bookbuddy.com.bookbuddybe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookDto {
    private Long id;
    private String title;
    private String description;
    private String coverimage;
    private boolean available;
}
