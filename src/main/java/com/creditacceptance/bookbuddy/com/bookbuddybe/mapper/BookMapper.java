package com.creditacceptance.bookbuddy.com.bookbuddybe.mapper;


import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.BookDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getDescription(), book.getCoverimage(), book.getAuthor(), book.isAvailable());
    }
    public static Book mapToBook(BookDto bookDto) {

        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setCoverimage(bookDto.getCoverimage());
        book.setAuthor(bookDto.getAuthor());
        book.setAvailable(bookDto.isAvailable());

        return book;
    }
}
