package com.creditacceptance.bookbuddy.com.bookbuddybe.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor

public class BookBuddyAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
