package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exeption.StudentNotFoundException;
import com.ltp.gradesubmission.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return unwrapStudent(student, id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();

    }

    static Student unwrapStudent(Optional<Student> studentOptional, Long id) {
        if (studentOptional.isPresent())
            return studentOptional.get();
        else
            throw new StudentNotFoundException(id);
    }
}