package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(Long id);

    BookDto updateBook(BookDto bookDto, Long id);

    List<BookDto> getAllBooks();
}
