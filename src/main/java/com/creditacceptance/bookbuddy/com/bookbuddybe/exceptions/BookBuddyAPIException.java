package com.creditacceptance.bookbuddy.com.bookbuddybe.exceptions;

import org.springframework.http.HttpStatus;

public class BookBuddyAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
