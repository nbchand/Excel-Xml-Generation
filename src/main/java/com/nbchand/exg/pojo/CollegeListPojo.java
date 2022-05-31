package com.nbchand.exg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CollegeListPojo {
    private List<CollegePojo> collegePojoList;
}
