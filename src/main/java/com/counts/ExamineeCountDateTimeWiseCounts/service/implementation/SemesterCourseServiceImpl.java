package com.counts.ExamineeCountDateTimeWiseCounts.service.implementation;

import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.CourseRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.requestDto.SemesterRequestDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.CourseResponseDto;
import com.counts.ExamineeCountDateTimeWiseCounts.dto.responseDto.SemesterResponseDto;
import com.counts.ExamineeCountDateTimeWiseCounts.entity.Course;
import com.counts.ExamineeCountDateTimeWiseCounts.entity.Semester;
import com.counts.ExamineeCountDateTimeWiseCounts.mapper.CourseMapper;
import com.counts.ExamineeCountDateTimeWiseCounts.mapper.SemesterMapper;
import com.counts.ExamineeCountDateTimeWiseCounts.repository.CourseRepository;
import com.counts.ExamineeCountDateTimeWiseCounts.repository.SemesterRepository;
import com.counts.ExamineeCountDateTimeWiseCounts.service.SemesterCourseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SemesterCourseServiceImpl implements SemesterCourseService {

    private final CourseRepository courseRepository;
    private final SemesterRepository semesterRepository;
    private final SemesterMapper semesterMapper;
    private final CourseMapper courseMapper;

    @Override
    public SemesterResponseDto createSemester(SemesterRequestDto semesterRequestDto) {
        Semester semester = semesterMapper.toSemester(semesterRequestDto);
        return semesterMapper.toSemesterResponseDto(semesterRepository.save(semester));
    }

    @Override
    public List<SemesterResponseDto> getAllSemesters() {
        List<Semester> semesters = semesterRepository.findAll();
        return semesterMapper.toSemesterResponseDtoList(semesters);
    }

    @Override
    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto, Long semesterId) {
        Semester semester = semesterRepository.findById(semesterId).orElseThrow(()-> new EntityNotFoundException("Semester not found"));
        Course course = courseMapper.toCourse(courseRequestDto);
        course.setSem(semester);
        semester.getCourses().add(course);
        return courseMapper.toCourseResponseDto(courseRepository.save(course));
    }

    @Override
    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.toCourseResponseDtoList(courses);
    }

    @Override
    public byte[] generateExamineeCountDateTimeWiseCounts(Long id) throws JRException {
        String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\report\\";
        Path path = Paths.get(filePath,"ExamineeCountDateTimeWiseCounts.jrxml");
        JasperReport report = JasperCompileManager.compileReport(path.toAbsolutePath().toString());
        Semester semester = semesterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Semester not found"));
        JRBeanCollectionDataSource semesterDataSource = new JRBeanCollectionDataSource(Collections.singletonList(semester));
        List<Course> courses = courseRepository.findBySem(semester);
        JRBeanCollectionDataSource courseDataSource = new JRBeanCollectionDataSource(courses);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("examDetails",courseDataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(report,parameters,semesterDataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
