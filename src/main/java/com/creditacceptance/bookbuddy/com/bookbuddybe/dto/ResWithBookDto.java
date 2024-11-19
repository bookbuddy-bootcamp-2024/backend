package com.creditacceptance.bookbuddy.com.bookbuddybe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResWithBookDto {
    private Long id;
    private Long bookid;
    private String title;
    private String author;
    private String description;
    private String coverimage;

}
