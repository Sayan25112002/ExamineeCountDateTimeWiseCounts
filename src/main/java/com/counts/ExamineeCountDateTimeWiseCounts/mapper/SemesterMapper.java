package com.counts.ExamineeCountDateTimeWiseCounts.mapper;

import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.SemesterRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.SemesterResponseDto;
import com.counts.ExamineeCountDateTimeWiseCounts.entity.Semester;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SemesterMapper {

    Semester toSemester(SemesterRequestDto semesterRequestDto);

    SemesterResponseDto toSemesterResponseDto(Semester semester);

    List<SemesterResponseDto> toSemesterResponseDtoList(List<Semester> semesters);

}
