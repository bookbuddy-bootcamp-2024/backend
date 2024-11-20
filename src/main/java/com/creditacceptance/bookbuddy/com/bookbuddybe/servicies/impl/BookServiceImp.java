package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.impl;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.BookDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Book;
import com.creditacceptance.bookbuddy.com.bookbuddybe.exceptions.ResourceNotFound;
import com.creditacceptance.bookbuddy.com.bookbuddybe.mapper.BookMapper;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.BookRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {
        //take the received object from client - the bookDto arg - and create a Book object from it, so
        //we can insert the Book object into our DB

        Book book = BookMapper.mapToBook(bookDto);

        //save the book in the DB via the repository object. take the returned Book object and put into a variable
        Book savedBook = bookRepository.save(book);

        //return a BookDto - create this DTO from our book object (in savedBook) by using our mapper
        return BookMapper.mapToBookDto(savedBook);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new ResourceNotFound("Book with given id not found!"));
        return BookMapper.mapToBookDto(book);
    }


    @Override
    public BookDto updateBook(BookDto bookDto, Long id) {
        // find the book we want to update;
        Book book = bookRepository.findById(id).orElseThrow(()->new ResourceNotFound("Book with given id not found!"));
        book.setAvailable(bookDto.isAvailable());
        Book savedBook = bookRepository.save(book);
        return BookMapper.mapToBookDto(savedBook);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream().map(BookMapper::mapToBookDto).collect(Collectors.toList());
    }
}
