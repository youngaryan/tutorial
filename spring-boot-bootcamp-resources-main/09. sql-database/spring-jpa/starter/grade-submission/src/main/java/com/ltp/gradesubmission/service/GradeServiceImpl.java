package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exeption.CourseNotFoundException;
import com.ltp.gradesubmission.exeption.GradeNotFoundException;
import com.ltp.gradesubmission.exeption.StudentNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;

    private CourseRepository courseRepository;

    private StudentRepository studentRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return unwrapGrade(grade, studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
        Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
        grade.setStudent(student);
        grade.setCourse(course);

        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Grade grade = unwrapGrade(gradeRepository.findByStudentIdAndCourseId(studentId, courseId), studentId, courseId);
        grade.setScore(score);
        gradeRepository.save(grade);
        return grade;
    }

    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

    static Grade unwrapGrade(Optional<Grade> gradeOptional, Long studentId, Long courseId) {
        if (gradeOptional.isPresent())
            return gradeOptional.get();
        else
            throw new GradeNotFoundException(studentId, courseId);
    }

}
