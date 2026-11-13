package com.counts.ExamineeCountDateTimeWiseCounts.repository;

import com.counts.ExamineeCountDateTimeWiseCounts.entity.Course;
import com.counts.ExamineeCountDateTimeWiseCounts.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findBySem(Semester semester);
}
