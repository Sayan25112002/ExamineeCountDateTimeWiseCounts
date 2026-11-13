package com.counts.ExamineeCountDateTimeWiseCounts.repository;

import com.counts.ExamineeCountDateTimeWiseCounts.entity.Course;
import com.counts.ExamineeCountDateTimeWiseCounts.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    List<Semester> findByCourses(List<Course> courses);
}
