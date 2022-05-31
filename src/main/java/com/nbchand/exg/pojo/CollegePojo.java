package com.nbchand.exg.pojo;

import com.nbchand.exg.entity.College;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CollegePojo {
    private Integer id;
    private String name;
    private String location;

    public CollegePojo(College college) {
        this.id = college.getId();
        this.name = college.getName();
        this.location = college.getLocation();
    }

    public static List<CollegePojo> collegeToDtoList(List<College> colleges) {
        return colleges.stream().map(college -> new CollegePojo(college)).collect(Collectors.toList());
    }
}
