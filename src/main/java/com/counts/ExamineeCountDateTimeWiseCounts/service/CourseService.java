package com.counts.ExamineeCountDateTimeWiseCounts.service;

import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.CourseRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.CourseResponseDto;

import java.util.List;

public interface CourseService {

    CourseResponseDto createCourse(CourseRequestDto courseRequestDto, Long semesterId);

    List<CourseResponseDto> getAllCourses();

}
