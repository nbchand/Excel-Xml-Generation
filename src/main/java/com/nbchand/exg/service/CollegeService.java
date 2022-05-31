package com.nbchand.exg.service;

import com.nbchand.exg.pojo.CollegePojo;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
public interface CollegeService {
    CollegePojo save(CollegePojo collegePojo);
    CollegePojo findById(Integer id);
    List<CollegePojo> findAll();
}
