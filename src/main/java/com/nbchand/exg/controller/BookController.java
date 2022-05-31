package com.nbchand.exg.controller;

import com.nbchand.exg.pojo.BookPojo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@RestController
@RequestMapping("/book")
/**
 * Just returns either xml or json as response
 */
public class BookController {

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public BookPojo display() {
        return new BookPojo(1, "The fault in our stars",
                "John Green", "123-123-123", LocalDate.now(),
                "Ekta Publication");
    }
}
