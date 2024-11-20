package com.creditacceptance.bookbuddy.com.bookbuddybe.controllers;


import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.BookDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @PreAuthorize("hasRole('ADMIN')")
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
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
       List<BookDto> bookDtoList = bookService.getAllBooks();
       return ResponseEntity.ok(bookDtoList);
    }
    @PutMapping("{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
        BookDto updatedBook = bookService.updateBook(bookDto, id);
        return ResponseEntity.ok(updatedBook);
    }
}
