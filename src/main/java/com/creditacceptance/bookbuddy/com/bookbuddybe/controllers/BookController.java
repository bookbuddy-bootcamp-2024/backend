package com.creditacceptance.bookbuddy.com.bookbuddybe.controllers;


import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.BookDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.BookService;
Import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto bookDtoSaved = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDtoSaved, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/books/1
    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id) {
        BookDto bookDto = bookService.getBookById(id);
        return ResponseEntity.ok(bookDto);

    }
}
