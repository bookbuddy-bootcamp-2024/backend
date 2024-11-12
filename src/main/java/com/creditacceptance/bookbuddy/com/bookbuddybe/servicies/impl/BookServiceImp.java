package com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.impl;

import com.creditacceptance.bookbuddy.com.bookbuddybe.dto.BookDto;
import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Book;
import com.creditacceptance.bookbuddy.com.bookbuddybe.exceptions.ResourceNotFound;
import com.creditacceptance.bookbuddy.com.bookbuddybe.mapper.BookMapper;
import com.creditacceptance.bookbuddy.com.bookbuddybe.repositories.BookRepository;
import com.creditacceptance.bookbuddy.com.bookbuddybe.servicies.BookService;
import lombok.AllArgsConstrutor;
import org.springframework.stereotype.Service;


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

    @override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new ResourceNotFound("Book with given id not found!"));
        return BookMapper.mapToBookDto(book);
    }
}
