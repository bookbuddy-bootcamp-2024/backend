package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(Long id);
}
