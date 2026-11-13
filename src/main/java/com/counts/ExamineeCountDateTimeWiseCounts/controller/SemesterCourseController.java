package com.counts.ExamineeCountDateTimeWiseCounts.controller;

import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.CourseRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.SemesterRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.CourseResponseDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.SemesterResponseDto;
import com.counts.ExamineeCountDateTimeWiseCounts.service.SemesterCourseService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class SemesterCourseController {

    public final SemesterCourseService semesterCourseService;

    @PostMapping("/createSemester")
    public SemesterResponseDto createSemester(@RequestBody SemesterRequestDto semesterRequestDto){
        return semesterCourseService.createSemester(semesterRequestDto);
    }

    @GetMapping("/getAllSemesters")
    public List<SemesterResponseDto> getAllSemesters(){
        return semesterCourseService.getAllSemesters();
    }

    @PostMapping("/createCourses")
    public CourseResponseDto createCourse(@RequestBody CourseRequestDto courseRequestDto, @RequestParam Long semesterId){
        return semesterCourseService.createCourse(courseRequestDto, semesterId);
    }

    @GetMapping("/getAllCourses")
    public List<CourseResponseDto> getAllCourses(){
        return semesterCourseService.getAllCourses();
    }

    @GetMapping("/generateExamineeCountDateTimeWiseCountsPdf")
    public HttpEntity<byte[]> generateExamineeCountDateTimeWiseCountsPdf(@RequestParam Long id) throws JRException {
        byte[] examineeCountDateTimeWiseCounts = semesterCourseService.generateExamineeCountDateTimeWiseCounts(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment","ExamineeCountDateTimeWiseCounts.pdf");
        return new HttpEntity<>(examineeCountDateTimeWiseCounts, headers);
    }
}
