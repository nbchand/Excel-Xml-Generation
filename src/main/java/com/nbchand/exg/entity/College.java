package com.nbchand.exg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "College_SEQ_GEN")
    @SequenceGenerator(name = "College_SEQ_GEN", sequenceName = "College_SEQ", allocationSize = 1)
    private Integer id;

    private String name;
    private String location;
}
