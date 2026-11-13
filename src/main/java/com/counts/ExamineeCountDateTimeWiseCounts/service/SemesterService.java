package com.counts.ExamineeCountDateTimeWiseCounts.service;

import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.SemesterRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.SemesterResponseDto;

import java.util.List;

public interface SemesterService {

    SemesterResponseDto createSemester(SemesterRequestDto semesterRequestDto);

    List<SemesterResponseDto> getAllSemesters();

    byte[] generateExamineeCountDateTimeWiseCounts(Long id);

}
