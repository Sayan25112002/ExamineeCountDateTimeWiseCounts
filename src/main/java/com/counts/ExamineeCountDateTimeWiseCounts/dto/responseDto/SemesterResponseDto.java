package com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto;

import com.counts.ExamineeCountDateTimeWiseCounts.entity.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SemesterResponseDto {

    private Long id;

    private String universityName;

    private String institutionName;

    private String semesterName;

    private List<CourseResponseDto> courses;

    private String totalStudents;

}
