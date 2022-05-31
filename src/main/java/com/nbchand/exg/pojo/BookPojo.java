package com.nbchand.exg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPojo {
    private Integer id;
    private String name;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
    private String publication;
}
