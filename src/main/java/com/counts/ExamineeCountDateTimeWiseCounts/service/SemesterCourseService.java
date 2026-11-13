package com.counts.ExamineeCountDateTimeWiseCounts.service;

import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.CourseRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.SemesterRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.CourseResponseDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.SemesterResponseDto;
import net.sf.jasperreports.engine.JRException;

import java.util.List;

public interface SemesterCourseService {

    SemesterResponseDto createSemester(SemesterRequestDto semesterRequestDto);

    List<SemesterResponseDto> getAllSemesters();

    CourseResponseDto createCourse(CourseRequestDto courseRequestDto, Long semesterId);

    List<CourseResponseDto> getAllCourses();

    byte[] generateExamineeCountDateTimeWiseCounts(Long id) throws JRException;

}
