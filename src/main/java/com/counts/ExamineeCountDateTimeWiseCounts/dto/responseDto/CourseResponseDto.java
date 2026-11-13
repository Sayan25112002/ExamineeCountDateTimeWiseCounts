package com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponseDto {

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

    private SemesterResponseDto sem;

}
