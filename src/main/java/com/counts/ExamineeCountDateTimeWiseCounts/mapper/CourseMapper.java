package com.counts.ExamineeCountDateTimeWiseCounts.mapper;

import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.CourseRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.CourseResponseDto;
import com.counts.ExamineeCountDateTimeWiseCounts.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toCourse(CourseRequestDto courseRequestDto);

    CourseResponseDto toCourseResponseDto(Course course);

    List<CourseResponseDto> toCourseResponseDtoList(List<Course> courses);

}
