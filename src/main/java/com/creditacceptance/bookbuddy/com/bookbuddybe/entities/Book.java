package com.creditacceptance.bookbuddy.com.bookbuddybe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="book_title", length=64)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name="cover_image")
    private String coverimage;

    private boolean available;
}
