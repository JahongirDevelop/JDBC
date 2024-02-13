package org.example;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Movie {
    private Integer id;
    private String title;
    private Long duration;
    private LocalDateTime createdDate;
    private LocalDate publishDate;
    private Double rating;
}
