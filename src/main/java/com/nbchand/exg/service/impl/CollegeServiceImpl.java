package com.nbchand.exg.service.impl;

import com.google.gson.Gson;
import com.nbchand.exg.entity.College;
import com.nbchand.exg.pojo.CollegePojo;
import com.nbchand.exg.repo.CollegeRepo;
import com.nbchand.exg.service.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Service
@RequiredArgsConstructor
public class CollegeServiceImpl implements CollegeService {

    private final CollegeRepo collegeRepo;

    private Gson gson = new Gson();

    @Override
    public CollegePojo save(CollegePojo collegePojo) {
        College college = gson.fromJson(gson.toJson(collegePojo), College.class);
        return new CollegePojo(collegeRepo.save(college));
    }

    @Override
    public CollegePojo findById(Integer id) {
        return new CollegePojo(collegeRepo.findById(id).orElseThrow(()-> new RuntimeException("Invalid id")));
    }

    @Override
    public List<CollegePojo> findAll() {
        return CollegePojo.collegeToDtoList(collegeRepo.findAll());
    }
}
