package com.nbchand.exg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Data
@AllArgsConstructor
public class Response {
    private String message;
    private Object data;
}
