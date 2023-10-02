package com.ltp.gradesubmission.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Grade;
import java.util.List;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);

    @Transactional
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);

    List<Grade> findByStudentId(Long StudentId);

    List<Grade> findByCourseId(Long courseId);
}