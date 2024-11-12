package com.creditacceptance.bookbuddy.com.bookbuddybe.mapper;


import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.BookDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getCoverimage(), book.isAvailable());
    }
    public static Book mapToBook(BookDto bookDto) {
        return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getCoverimage(), bookDto.isAvailable());
    }
}
