package com.counts.ExamineeCountDateTimeWiseCounts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String universityName;

    private String institutionName;

    private String semesterName;

    @OneToMany(mappedBy = "sem")
    @JsonIgnore
    private List<Course> courses;

    private String totalStudents;

}
