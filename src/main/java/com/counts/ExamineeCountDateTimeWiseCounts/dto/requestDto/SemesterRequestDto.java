package com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SemesterRequestDto {

    private String universityName;

    private String institutionName;

    private String semesterName;

    private String totalStudents;

}
