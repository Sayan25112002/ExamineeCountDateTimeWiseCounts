package com.counts.ExamineeCountDateTimeWiseCounts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String semester;

    private String examCenter;

    private String examDate;

    private String examTime;

    private String course;

    private String courseType;

    private String courseId;

    private String paperType;

    private String paperNature;

    private String totalStudent;

    @ManyToOne
    @JsonIgnore
    private Semester sem;

}
