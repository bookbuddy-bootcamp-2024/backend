package com.creditacceptance.bookbuddy.com.bookbuddybe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


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
    @Column(name="title", length=64)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name="coverimage")
    private String coverimage;

    private String author;

    private boolean available;

    @OneToMany(mappedBy = "book")
    private Set<Reservation> reservationSet;
}
