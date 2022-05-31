package com.nbchand.exg.repo;

import com.nbchand.exg.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
public interface CollegeRepo extends JpaRepository<College, Integer> {
}
